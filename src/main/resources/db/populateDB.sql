DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password');

INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100000, 100001, '2015-05-30 10:23:42', 'Завтрак', '500');

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100001, 100001, '2015-05-30 13:23:42', 'Обед', '1000');

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100002, 100001, '2015-05-30 20:23:42', 'Ужин', '500');

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100003, 100001, '2015-05-31 10:23:42', 'Завтрак', '1000');

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100004, 100001, '2015-05-31 13:23:42', 'Обед', '500');

IINSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100005, 100001, '2015-05-31 20:23:42', 'Ужин', '510');

IINSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100006, 100000, '2015-05-31 10:23:42', 'Завтрак', '1111');

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100007, 100000, '2015-05-31 13:23:42', 'Обед', '700');

INSERT INTO meals (id, user_id, date_time, description, calories)
VALUES (100008, 100000, '2015-05-31 20:23:42', 'Ужин', '800');