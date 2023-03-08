create table author
(
    id     serial primary key,
    fio    varchar  not null,
    date   timestamp  not null
);

alter table budget add column author int