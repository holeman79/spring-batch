package com.example.springbatch.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPay is a Querydsl query type for Pay
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPay extends EntityPathBase<Pay> {

    private static final long serialVersionUID = 2124719792L;

    public static final QPay pay = new QPay("pay");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> txDateTime = createDateTime("txDateTime", java.time.LocalDateTime.class);

    public final StringPath txName = createString("txName");

    public QPay(String variable) {
        super(Pay.class, forVariable(variable));
    }

    public QPay(Path<? extends Pay> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPay(PathMetadata metadata) {
        super(Pay.class, metadata);
    }

}

