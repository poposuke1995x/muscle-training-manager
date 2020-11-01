-- Users schema

-- !Ups

create table if not exists users
(
    id           serial primary key,
    name         varchar(50) not null,
    firebase_uid varchar(200) unique
);

insert into users (name, firebase_uid)
values ('@system', '164T8tZhiAZ27o5F6z6lVFyi4NJ3');

insert into users (name, firebase_uid)
values ('@giyu', 'KfhiAkbayARugdCX7bPzvhQguhg1');

insert into users (name, firebase_uid)
values ('@inosuke', 'CPCts14Hq4X4UeMxLnqK70zh83K3');

insert into users (name, firebase_uid)
values ('@zenitsu', 'SmB7x3bf0qOnY3L3QG1ECvklYLv2');

insert into users (name, firebase_uid)
values ('@nezuko', 'kthP6Uri5DRbs5KwEG07krKp2XU2');

insert into users (name, firebase_uid)
values ('@kanao', 'zdNtokWPn5U991NjycibUSMWeen1');

-- !Downs
drop table users;