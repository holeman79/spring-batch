package com.example.springbatch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPay2 is a Querydsl query type for Pay2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPay2 extends EntityPathBase<Pay2> {

    private static final long serialVersionUID = 1441804162L;

    public static final QPay2 pay2 = new QPay2("pay2");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> txDateTime = createDateTime("txDateTime", java.time.LocalDateTime.class);

    public final StringPath txName = createString("txName");

    public QPay2(String variable) {
        super(Pay2.class, forVariable(variable));
    }

    public QPay2(Path<? extends Pay2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPay2(PathMetadata metadata) {
        super(Pay2.class, metadata);
    }

}

