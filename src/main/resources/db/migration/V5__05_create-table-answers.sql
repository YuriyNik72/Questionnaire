
DROP TABLE IF EXISTS answers;
CREATE TABLE answers (
       id bigserial primary key,
       title varchar (2000),
       question_id bigint not null
       REFERENCES questions (id)
);