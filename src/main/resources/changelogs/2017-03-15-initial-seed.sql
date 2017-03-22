--liquibase formatted sql

--changeset achyut:initial-seed
insert into users (id, name, address) values ('a793d5d0-2c81-4c51-a54c-c26345658b14', 'Admin', 'Admin');
insert into users (id, name, address) values ('67b63402-b660-438d-b495-50b24e07ba86', 'Test', 'Test');
