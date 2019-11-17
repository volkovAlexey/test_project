CREATE TABLE addresses (
  id      SERIAL      NOT NULL CONSTRAINT addresses_key PRIMARY KEY,
  country VARCHAR(20) NOT NULL,
  region  VARCHAR(20) NOT NULL,
  city    VARCHAR(20) NOT NULL
);

CREATE TABLE users (
  id         SERIAL      NOT NULL CONSTRAINT users_key PRIMARY KEY,
  user_name  VARCHAR(20) NOT NULL UNIQUE,
  password   VARCHAR(20) NOT NULL,
  email      VARCHAR(30) NOT NULL UNIQUE,
  address_id BIGINT      NOT NULL,

  CONSTRAINT fk_addresses_users_id FOREIGN KEY (address_id) REFERENCES addresses (id)
);