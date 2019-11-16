CREATE TABLE users (
  id        SERIAL      NOT NULL CONSTRAINT users_key PRIMARY KEY,
  user_name VARCHAR(20) NOT NULL UNIQUE,
  password  VARCHAR(20) NOT NULL
);

CREATE TABLE roles (
  id   SERIAL      NOT NULL CONSTRAINT roles_key PRIMARY KEY,
  name VARCHAR(20) NOT NULL
);

CREATE TABLE user_roles (
  user_id SERIAL NOT NULL,
  role_id SERIAL NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
);