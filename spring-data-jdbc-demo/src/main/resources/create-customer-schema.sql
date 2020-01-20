CREATE TABLE customer
(
    id         INTEGER IDENTITY PRIMARY KEY,
    first_name VARCHAR(200),
    last_name  VARCHAR(200),
    birthday   DATE,
);

create TABLE address
(
    customer     INTEGER,
    street       VARCHAR(200),
    city         VARCHAR(200),
    zip_code     VARCHAR(200),
);