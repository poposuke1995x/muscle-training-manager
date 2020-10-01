-- Categories schema

-- !Ups

create type category as enum('胸', '背中', '肩', '脚', '腹筋・体幹', '有酸素', 'その他');

create table if not exists categories (
  id serial primary key,
  name category not null
  );

insert into categories (name) values ('胸');
insert into categories (name) values ('背中');
insert into categories (name) values ('肩');
insert into categories (name) values ('脚');
insert into categories (name) values ('腹筋・体幹');
insert into categories (name) values ('有酸素');
insert into categories (name) values ('その他');

-- !Downs