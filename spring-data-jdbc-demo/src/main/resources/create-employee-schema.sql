CREATE TABLE employee
(
    id         INTEGER IDENTITY PRIMARY KEY,
    first_name VARCHAR(200),
    last_name  VARCHAR(200),
    phone_number VARCHAR(50),
    emergency_contact_info VARCHAR(50),
);