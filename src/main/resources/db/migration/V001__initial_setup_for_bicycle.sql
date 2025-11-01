create table bicycle(
    id           bigint primary key,
    name         varchar(255),
    color        varchar(255),
    model        varchar(255),
    in_stock      bigint,
    manufacturer_id bigint
);

create sequence bicycle_seq increment by 1 start with 1;