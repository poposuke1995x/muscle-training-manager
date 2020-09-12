-- BodyParts schema

-- !Ups

create table if not exists body_parts (
  id serial primary key,
  name varchar(50) not null
  );

insert into body_parts (name) values ('大胸筋 全体');
insert into body_parts (name) values ('大胸筋 上部');
insert into body_parts (name) values ('大胸筋 中部');
insert into body_parts (name) values ('大胸筋 下部');
insert into body_parts (name) values ('広背筋 全体');
insert into body_parts (name) values ('広背筋 上部');
insert into body_parts (name) values ('広背筋 中部');
insert into body_parts (name) values ('広背筋 下部');
insert into body_parts (name) values ('三角筋 前部');
insert into body_parts (name) values ('三角筋 中部');
insert into body_parts (name) values ('三角筋 後部');
insert into body_parts (name) values ('大腿四頭筋 全体');
insert into body_parts (name) values ('大腿四頭筋 表');
insert into body_parts (name) values ('大腿四頭筋 裏');
insert into body_parts (name) values ('ハムストリング');
insert into body_parts (name) values ('ヒラメ筋');
insert into body_parts (name) values ('僧帽筋');
insert into body_parts (name) values ('大円筋');
insert into body_parts (name) values ('腹筋');
insert into body_parts (name) values ('腹斜筋');
-- !Downs