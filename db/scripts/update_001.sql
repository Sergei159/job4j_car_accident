CREATE TABLE IF NOT EXISTS accident_type (
  id serial primary key,
  name varchar(2000)
);

INSERT INTO accident_type (name) VALUES
('Две машины'),( 'Машина и человек'), ('Машина и велосипед');

CREATE TABLE IF NOT EXISTS rules (
  id serial primary key,
  name varchar(2000)
);

INSERT INTO rules (name) VALUES
('Статья.1'),( 'Статья.2'), ('Статья.3');


CREATE TABLE IF NOT EXISTS accident (
  id serial primary key,
  name varchar(2000),
  text varchar(2000),
  address varchar(2000),
  accident_type_id int not null REFERENCES accident_type(id),
  rules_id int  REFERENCES rules(id)
);

CREATE TABLE IF NOT EXISTS accident_rules (
accident_id int references accident(id),
rules_id int references rules(id)
)