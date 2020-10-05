-- BodyParts schema

-- !Ups

create table if not exists body_parts (
  id serial primary key,
  name varchar(50) not null,
  category_id integer references categories(id) on delete cascade
  );

insert into body_parts (name, category_id) values ('大胸筋 全体', 1);
insert into body_parts (name, category_id) values ('大胸筋 上部', 1);
insert into body_parts (name, category_id) values ('大胸筋 中部', 1);
insert into body_parts (name, category_id) values ('大胸筋 下部', 1);
insert into body_parts (name, category_id) values ('広背筋 全体', 2);
insert into body_parts (name, category_id) values ('広背筋 上部', 2);
insert into body_parts (name, category_id) values ('広背筋 中部', 2);
insert into body_parts (name, category_id) values ('広背筋 下部', 2);
insert into body_parts (name, category_id) values ('三角筋 前部', 3);
insert into body_parts (name, category_id) values ('三角筋 中部', 3);
insert into body_parts (name, category_id) values ('三角筋 後部', 3);
insert into body_parts (name, category_id) values ('大腿四頭筋 全体', 4);
insert into body_parts (name, category_id) values ('大腿四頭筋 表', 4);
insert into body_parts (name, category_id) values ('大腿四頭筋 裏', 4);
insert into body_parts (name, category_id) values ('ハムストリング', 4);
insert into body_parts (name, category_id) values ('ヒラメ筋', 4);
insert into body_parts (name, category_id) values ('僧帽筋', 2);
insert into body_parts (name, category_id) values ('大円筋', 2);
insert into body_parts (name, category_id) values ('腹筋', 5);
insert into body_parts (name, category_id) values ('腹斜筋', 5);
-- !Downs