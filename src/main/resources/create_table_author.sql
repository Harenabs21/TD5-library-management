CREATE TABLE IF NOT EXISTS author
(
    id   int PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    sex  CHAR         NOT NULL
);
INSERT INTO author (id,name,sex) VALUES (1,'Victor Hugo','M'),(2,'J.K Rowlings','F'),(3,'Albert Camus','M');