package com.example.springbatch.querydsl.job;

import com.example.springbatch.domain.Pay;
import com.example.springbatch.domain.Pay2;
import com.example.springbatch.domain.PayDto;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

import static com.example.springbatch.domain.QPay.pay;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class QuerydslJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;
    private final QuerydslPagingItemReaderJobParameter jobParameter;

    private static final int chunkSize = 10;

    @Bean
    @JobScope
    public QuerydslPagingItemReaderJobParameter jobParameter() {
        return new QuerydslPagingItemReaderJobParameter();
    }

    @Bean
    public Job querydslJob(){
        return jobBuilderFactory.get("querydslJob")
                .start(querydslStep())
                .build();
    }

    @Bean
    public Step querydslStep(){
        return stepBuilderFactory.get("querydslStep")
                .<PayDto, Pay2>chunk(chunkSize)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();

    }

    @Bean
    public QuerydslPagingItemReader<PayDto> reader(){
        return new QuerydslPagingItemReader<>(entityManagerFactory, chunkSize, jpaQueryFactory -> jpaQueryFactory
                .from(pay)
                .where(pay.amount.gt(jobParameter.getAmount()))
                .select(Projections.constructor(PayDto.class, pay.amount, pay.txName, pay.txDateTime)));
    }

    @Bean
    public ItemProcessor<PayDto, Pay2> processor(){
        return payDto -> new Pay2(payDto.getAmount(), payDto.getTxName(), payDto.getTxDateTime());
    }

    @Bean
    public JpaItemWriter<Pay2> writer(){
        return new JpaItemWriterBuilder<Pay2>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }
}

