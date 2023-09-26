
DROP TABLE IF EXISTS answers cascade;
CREATE TABLE answers (
       id bigserial primary key,
       answer_1 varchar (2000),
       answer_2 varchar (2000),
       answer_3 varchar (2000)
);
insert into answers (answer_1,answer_2,answer_3 ) values ('1','2','3');
