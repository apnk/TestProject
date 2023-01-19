drop all objects;

create table if not exists sub_account (
    id bigint primary key auto_increment,
    currency varchar(3) not null,
    amount numeric not null
);

create table if not exists account (
    id bigint primary key auto_increment,
    name varchar not null,
    second_name varchar not null,
    pesel varchar(11) not null,
    sub_account_id BIGINT REFERENCES sub_account(id)
);

alter table account add constraint pesel_unique unique(pesel);

