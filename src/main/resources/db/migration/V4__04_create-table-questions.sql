
DROP TABLE IF EXISTS questions cascade;
CREATE TABLE questions (
     id bigserial primary key,
     title varchar (2000)
);