CREATE TABLE IF NOT EXISTS document (
  id                    INTEGER IDENTITY PRIMARY KEY,
  description           VARCHAR(1000),
  created_user          CHAR(100),
  last_modified_user    CHAR(100),
  created_date          DATE,
  last_modified_date    DATE,
);