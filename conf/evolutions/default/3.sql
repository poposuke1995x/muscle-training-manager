-- Categories schema

-- !Ups

create table if not exists categories (
  id serial primary key,
  name varchar(50) not null
  );

insert into categories (name) values ('胸');
insert into categories (name) values ('背中');
insert into categories (name) values ('肩');
insert into categories (name) values ('脚');
insert into categories (name) values ('腹筋・体幹');
insert into categories (name) values ('有酸素');
insert into categories (name) values ('その他');

-- !Downs