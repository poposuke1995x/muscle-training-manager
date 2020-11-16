-- Users schema

-- !Ups

create table if not exists users
(
    id           serial primary key,
    name         varchar(50) not null,
    firebase_uid varchar(200) unique
);

insert into users (name, firebase_uid) values ('system', '164T8tZhiAZ27o5F6z6lVFyi4NJ3');

-- !Downs
drop table users;