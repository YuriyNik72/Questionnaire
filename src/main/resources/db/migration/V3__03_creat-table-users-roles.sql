DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
    user_id bigint NOT NULL,
    role_id int NOT NULL,
            PRIMARY KEY (user_id,role_id),
            FOREIGN KEY (user_id) REFERENCES users (id),
            FOREIGN KEY (role_id) REFERENCES roles (id)
);
insert into users_roles (user_id, role_id) VALUES (1,3);