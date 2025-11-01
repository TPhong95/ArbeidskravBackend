create table manufacturer
(
    id          bigint primary key,
    name        varchar(255),
    email       varchar(255),
    phone_number varchar(255),
    Bicycle_id   bigint
);

create sequence manufacturer_seq increment by 1 start with 1;