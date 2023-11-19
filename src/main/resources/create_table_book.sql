CREATE TABLE IF NOT EXISTS book(
    id int PRIMARY KEY ,
    name VARCHAR(200) NOT NULL ,
    page_number int NOT NULL ,
    topic VARCHAR(100) NOT NULL ,
    release_date DATE NOT NULL
)
-- Livre de comédie
INSERT INTO book (id, name, page_number, topic, release_date)
VALUES (1, 'Les Aventures de Tom Sawyer', 250, 'COMEDY', '1876-12-10');

-- Livre romantique
INSERT INTO book (id, name, page_number, topic, release_date)
VALUES (2, 'Orgueil et Préjugés', 350, 'ROMANCE', '1813-01-28');

-- Autre genre de livre
INSERT INTO book (id, name, page_number, topic, release_date)
VALUES (3, '1984', 300, 'OTHER', '1949-06-08');
