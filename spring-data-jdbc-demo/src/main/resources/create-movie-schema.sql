CREATE TABLE movie
(
    id  INTEGER IDENTITY PRIMARY KEY,
    title VARCHAR(200),
    description  VARCHAR(200),
);

create TABLE rental
(
    movie     INTEGER,
    duration  VARCHAR(300),
    price     INTEGER,
);




















create TABLE rental_history
(
    movie INTEGER,
    movie_key INTEGER,
    rental_date DATE
);

create TABLE actor
(
    movie INTEGER,
    movie_key VARCHAR(30),
    name VARCHAR(30)
);