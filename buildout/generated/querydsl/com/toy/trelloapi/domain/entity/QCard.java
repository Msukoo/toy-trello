package com.toy.trelloapi.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCard is a Querydsl query type for Card
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCard extends EntityPathBase<Card> {

    private static final long serialVersionUID = 1809405898L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCard card = new QCard("card");

    public final NumberPath<Long> cardId = createNumber("cardId", Long.class);

    public final NumberPath<Long> cardOrd = createNumber("cardOrd", Long.class);

    public final StringPath cardTitle = createString("cardTitle");

    public final DateTimePath<java.time.LocalDateTime> modDtime = createDateTime("modDtime", java.time.LocalDateTime.class);

    public final StringPath modId = createString("modId");

    public final DateTimePath<java.time.LocalDateTime> regDtime = createDateTime("regDtime", java.time.LocalDateTime.class);

    public final StringPath regId = createString("regId");

    public final BooleanPath useYn = createBoolean("useYn");

    public final QWorkList workList;

    public QCard(String variable) {
        this(Card.class, forVariable(variable), INITS);
    }

    public QCard(Path<? extends Card> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCard(PathMetadata metadata, PathInits inits) {
        this(Card.class, metadata, inits);
    }

    public QCard(Class<? extends Card> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.workList = inits.isInitialized("workList") ? new QWorkList(forProperty("workList")) : null;
    }

}

