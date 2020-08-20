-- LiftTypes schema

-- !Ups

create table if not exists lift_types (
  id serial primary key,
  name varchar(50) not null,
  reference_url varchar(200),
  description varchar(200),
  imported_count integer default 0,
  server_uid varchar(200) references users(firebase_uid),
  default_rep integer default 0,
  default_weight integer default 0,
  default_set_count integer default 0,
  share_flag boolean not null default false
  );

insert into lift_types (name, server_uid, default_rep, default_weight, default_set_count) values ('ベンチプレス', '164T8tZhiAZ27o5F6z6lVFyi4NJ3', 10, 10, 3);

-- !Downs