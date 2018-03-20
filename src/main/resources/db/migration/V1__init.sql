create table customers (
    id SERIAL,
    first_name varchar(255),
    last_name varchar(255),
    primary key (id)
);

INSERT INTO customers(id, first_name, last_name)
VALUES (1, 'first', 'Bauer');