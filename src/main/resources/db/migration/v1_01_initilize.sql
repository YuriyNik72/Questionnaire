

drop table  if exists users cascade;
create table users (
    id  bigserial primary key,
    username  varchar(60)  not null,
    password  varchar(256) not null,
    email   varchar(120) not null
            unique
);
insert into users (username, password, email) VALUES ('user', '$2y$10$AYxR6pZd1LPECNtwfqqo2ejp/q51WuhvjhmwV0h.ZWOro3n1IHuvi', 'user@mail.com');