CREATE TABLE IF NOT EXISTS visitor(
    id int PRIMARY KEY,
    name VARCHAR(200) NOT NULL ,
    reference VARCHAR(200) NOT NULL
)
-- Premier visiteur
INSERT INTO visitor (id, name, reference)
VALUES (1, 'Alice Wonderland', 'ABC123');

-- Deuxième visiteur
INSERT INTO visitor (id, name, reference)
VALUES (2, 'Bob Marley', 'XYZ789');

-- Troisième visiteur
INSERT INTO visitor (id, name, reference)
VALUES (3, 'Charlie Chaplin', 'PQR456');
