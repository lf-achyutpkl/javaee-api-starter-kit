--liquibase formatted sql

--changeset achyut:initial-schema-design
CREATE TABLE IF NOT EXISTS users (
    id uuid primary key,
    name varchar(255),
    address varchar(255)
);
--rollback drop table users;
