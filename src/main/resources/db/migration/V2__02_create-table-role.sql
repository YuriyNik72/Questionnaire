DROP TABLE IF EXISTS roles cascade ;

CREATE TABLE roles (
    id     serial primary key,
    name   varchar(60)  not null
);
insert into roles (name) values ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_MANAGER');