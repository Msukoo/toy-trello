package com.toy.trelloapi.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkList is a Querydsl query type for WorkList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWorkList extends EntityPathBase<WorkList> {

    private static final long serialVersionUID = -1356207351L;

    public static final QWorkList workList = new QWorkList("workList");

    public final ListPath<Card, QCard> card = this.<Card, QCard>createList("card", Card.class, QCard.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> modDtime = createDateTime("modDtime", java.time.LocalDateTime.class);

    public final StringPath modId = createString("modId");

    public final DateTimePath<java.time.LocalDateTime> regDtime = createDateTime("regDtime", java.time.LocalDateTime.class);

    public final StringPath regId = createString("regId");

    public final BooleanPath useYn = createBoolean("useYn");

    public final NumberPath<Long> workListId = createNumber("workListId", Long.class);

    public final NumberPath<Long> workListOrd = createNumber("workListOrd", Long.class);

    public final StringPath workListTitle = createString("workListTitle");

    public QWorkList(String variable) {
        super(WorkList.class, forVariable(variable));
    }

    public QWorkList(Path<? extends WorkList> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkList(PathMetadata metadata) {
        super(WorkList.class, metadata);
    }

}

