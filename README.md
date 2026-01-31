# Quora-Clone

 create table answers (
       id binary(255) not null,
        content varchar(255),
        created_at datetime(6),
        updated_at datetime(6),
        question_id binary(255),
        user_id binary(255),
        primary key (id)
    ) engine=InnoDB
Hibernate: 

    create table comments (
       id binary(255) not null,
        comment varchar(255),
        created_at datetime(6),
        updated_at datetime(6),
        answer_id binary(255),
        user_id binary(255),
        parent_comment_id binary(255),
        primary key (id)
    ) engine=InnoDB
Hibernate: 

    create table questions (
       id binary(255) not null,
        body varchar(255) not null,
        created_at datetime(6) not null,
        title varchar(255) not null,
        topic_id binary(255),
        user_id binary(255),
        primary key (id)
    ) engine=InnoDB
Hibernate: 

    create table topics (
       id binary(255) not null,
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB
Hibernate: 

    create table users (
       id binary(255) not null,
        bio varchar(255),
        created_at datetime(6),
        email varchar(255) not null,
        password varchar(255) not null,
        role varchar(255),
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB
Hibernate: 

    alter table answers
       add constraint FK3erw1a3t0r78st8ty27x6v3g1
       foreign key (question_id)
       references questions (id)
Hibernate: 

    alter table answers
       add constraint FK5bp3d5loftq2vjn683ephn75a
       foreign key (user_id)
       references users (id)
Hibernate: 

    alter table comments
       add constraint FKoiwlwqmu9qm0tjnafxqr20rd8
       foreign key (answer_id)
       references answers (id)
Hibernate: 

    alter table comments
       add constraint FK8omq0tc18jd43bu5tjh6jvraq
       foreign key (user_id)
       references users (id)
Hibernate: 

    alter table comments
       add constraint FK7h839m3lkvhbyv3bcdv7sm4fj
       foreign key (parent_comment_id)
       references comments (id)
Hibernate: 

    alter table questions
       add constraint FKdb5p6ukb0v76he4pq87cbymhg
       foreign key (topic_id)
       references topics (id)
Hibernate: 

    alter table questions
       add constraint FKjoo8hp6d3gfwctr68dl2iaemj
       foreign key (user_id)
       references users (id)