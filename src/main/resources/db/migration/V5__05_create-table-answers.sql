
DROP TABLE IF EXISTS answers cascade;
CREATE TABLE answers (
       id bigserial primary key,
       answer_1 varchar (2000),
       answer_2 varchar (2000),
       answer_3 varchar (2000),
       question_id int
--        FOREIGN KEY (question_id)
                     REFERENCES questions (id)
                     on delete CASCADE
);
-- insert into answers (answer_1,answer_2,answer_3,question_id) values ('one','two','tree',1);
