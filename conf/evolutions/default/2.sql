-- LiftTypes schema

-- !Ups

create table if not exists lift_types
(
    id                serial primary key,
    name              varchar(50) not null,
    reference_url     varchar(200),
    description       varchar(200),
    imported_count    integer              default 0,
    user_id           integer references users (id) on delete cascade,
    default_rep       integer              default 0,
    default_weight    integer              default 0,
    default_set_count integer              default 0,
    share_flag        boolean     not null default false
);

insert into lift_types (name, user_id, default_rep, default_weight, default_set_count)
values ('ベンチプレス', 1, 45, 10, 3);

insert into lift_types (name, user_id, default_rep, default_weight, default_set_count)
values ('デッドリフト', 1, 80, 10, 2);

insert into lift_types (name, user_id, default_rep, default_weight, default_set_count)
values ('スクワット', 1, 70, 8, 3);


-- !Downs