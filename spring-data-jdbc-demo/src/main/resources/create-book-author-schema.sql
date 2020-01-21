create table author (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    birth_date DATE
);

create table book (
    id INTEGER IDENTITY PRIMARY KEY,
    isbn VARCHAR(100),
    title VARCHAR(100),
);

 create table book_author (
    author INTEGER,
    book INTEGER
);