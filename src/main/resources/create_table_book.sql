CREATE TABLE IF NOT EXISTS book(
    id int PRIMARY KEY ,
    name VARCHAR(200) NOT NULL ,
    page_number int NOT NULL ,
    topic VARCHAR(100) NOT NULL ,
    release_date DATE NOT NULL
)