
DROP TABLE IF EXISTS questions cascade;
CREATE TABLE questions (
     id bigserial primary key,
     question varchar (2000),
     category_id int
         REFERENCES categories (id)
);
-- insert into questions (question) values ('fghytjh');