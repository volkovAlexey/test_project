CREATE TABLE countries (
  id   SERIAL      NOT NULL CONSTRAINT countries_key PRIMARY KEY,
  name VARCHAR(30) NOT NULL
);

CREATE TABLE regions (
  id         SERIAL      NOT NULL CONSTRAINT regions_key PRIMARY KEY,
  name       VARCHAR(30) NOT NULL,
  country_id BIGINT      NOT NULL,

  CONSTRAINT fk_countries_regions_id FOREIGN KEY (country_id) REFERENCES countries (id)
);

CREATE TABLE addresses (
  id        SERIAL      NOT NULL CONSTRAINT addresses_key PRIMARY KEY,
  city      VARCHAR(30) NOT NULL,
  region_id BIGINT      NOT NULL,

  CONSTRAINT fk_regions_addresses_id FOREIGN KEY (region_id) REFERENCES regions (id)
);

CREATE TABLE users (
  id         SERIAL      NOT NULL CONSTRAINT users_key PRIMARY KEY,
  user_name  VARCHAR(20) NOT NULL UNIQUE,
  password   VARCHAR(40) NOT NULL,
  email      VARCHAR(30) NOT NULL UNIQUE,
  address_id BIGINT      NOT NULL,

  CONSTRAINT fk_addresses_users_id FOREIGN KEY (address_id) REFERENCES addresses (id)
);