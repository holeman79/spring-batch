package com.example.springbatch.querydsl.job;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Slf4j
@NoArgsConstructor
public class QuerydslPagingItemReaderJobParameter {
    private int amount;

    @Value("#{jobParameters[amount]}")
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
