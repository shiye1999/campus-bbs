drop table if exists comment;
drop table if exists post;
drop table if exists section;
drop table if exists relation;
drop table if exists user;


create table user
(
    id             int auto_increment,
    authority      int                        not null,
    school_number  varchar(10)                not null,
    username       varchar(20)                not null,
    password       varchar(20)                not null,
    avatar         varchar(100) default ''    null,
    comment_number int          default 0     not null,
    last_time      datetime     default now() null,
    create_time    datetime     default now() not null,
    constraint user_pk
        primary key (id)
);

create table section
(
    id           int         not null,
    section_name varchar(40) not null,
    constraint section_pk
        primary key (id)
);

create table post
(
    id              int               not null,
    post_name       int               not null,
    section_id      int               not null,
    creator_id      int               null,
    click_num       int  default 0    null,
    allow_anonymous bool default true null,
    last_time       datetime          null,
    create_time     datetime          null,
    constraint post_pk
        primary key (id),
    constraint post_section_id_fk
        foreign key (section_id) references section (id),
    constraint post_user_id_fk
        foreign key (creator_id) references user (id)
);

create table comment
(
    id           int                  not null
        primary key,
    section_id   int                  not null,
    post_id      int                  not null,
    content varchar(200)         not null,
    creator_id   int                  not null,
    create_time  datetime             not null,
    is_anonymous tinyint(1) default 0 not null,
    is_hidden    tinyint(1) default 0 not null,
    reply_to     int                  null,
    constraint comment_user_id_fk
        foreign key (creator_id) references user (id),
    constraint section_user_id_fk
        foreign key (creator_id) references section (id)
);

create table relation
(
    publisher_id  int not null,
    subscriber_id int not null,
    constraint relation_user_id_fk
        foreign key (publisher_id) references user (id),
    constraint relation_user_id_fk_2
        foreign key (publisher_id) references user (id)
);

insert into user(authority, school_number, username, password)
values (1, 11811202, 'csp', '123456');