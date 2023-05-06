create table if not exists users
(
    id            bigserial primary key not null,
    nickname      varchar not null ,
    email         varchar unique not null ,
    sex           boolean not null ,
    weight        real not null ,
    height        real not null ,
    date_of_birth real not null ,
    password      varchar not null
);