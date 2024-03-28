DROP TABLE IF EXISTS categories cascade;
CREATE TABLE categories (
                         id bigserial primary key,
                         name varchar (200)
                        );
insert into categories (name) VALUES ('ЭТО');
insert into categories (name) VALUES ('ТМО');
insert into categories (name) VALUES ('ОТ');
