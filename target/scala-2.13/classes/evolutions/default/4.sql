-- TrainingMenu schema

-- !Ups

create table if not exists training_menu (
  id serial primary key,
  name varchar(50) not null,
  category_id integer references categories(id),
  description varchar(200),
  imported_count integer default 0,
  user_uid varchar(200) references users(firebase_uid),
  share_flag boolean default false
  );

insert into training_menu (name, category_id, user_uid, share_flag) values ('胸の日', 1, '164T8tZhiAZ27o5F6z6lVFyi4NJ3', true);

-- !Downs