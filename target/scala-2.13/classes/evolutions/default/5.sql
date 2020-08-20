-- BodyParts schema

-- !Ups

create table if not exists body_parts (
  id serial primary key,
  name varchar(50) not null
  );

insert into body_parts (name) values ('大胸筋 全体');

-- !Downs