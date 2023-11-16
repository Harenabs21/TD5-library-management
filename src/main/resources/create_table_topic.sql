CREATE TABLE IF NOT EXISTS topics(
    id int PRIMARY KEY ,
    topic_name VARCHAR(100) NOT NULL
                                 );
INSERT INTO topics (id,topic_name) VALUES (1,'COMEDY'),(2,'ROMANCE'),(3,'OTHER');