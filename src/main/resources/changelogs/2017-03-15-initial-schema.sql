--liquibase formatted sql

--changeset achyut:initial-schema-design
create table users (
    id uuid primary key,
    name varchar(255),
    address varchar(255)
);
--rollback drop table users;
