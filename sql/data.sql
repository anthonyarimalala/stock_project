CREATE DATABASE stock_project;
\c stock_project

-- DELETE TABLE mouvement;
-- DELETE TABLE stock;
-- DELETE TABLE article;
-- DELETE TABLE magasin;

CREATE TABLE magasin(
    id_magasin VARCHAR(10) PRIMARY KEY,
    magasin VARCHAR(255),
    emplacement VARCHAR(255)
);
INSERT INTO magasin VALUES
    ('MAG001', 'Leader Price', 'Andranomena'),
    ('MAG002', 'Leader Price', 'Tanjombato'),
    ('MAG003', 'Leader Price', 'Tamatave');


CREATE TABLE article(
    id_article VARCHAR(10) PRIMARY KEY,
    article VARCHAR(255),
    description TEXT,
    famille VARCHAR(255),
    unite VARCHAR(55),
    type_sortie VARCHAR(10)
);
INSERT INTO article VALUES
    ('NI001','Sedap Supreme','Fabriqué en Inde','Nouille Instantané','Piece','FIFO'),
    ('NI002','Nouille Matsiro Salone','Nouille vita Gasy','Nouille Instantané','Piece','FIFO'),
    ('NI003','Presto','','Nouille Instantané','Piece','FIFO'),
    ('B001','Basket-ball','','Ballon','Piece','LIFO'),
    ('B002','Ballon de Rubgy','','Ballon','Piece','LIFO');


CREATE TABLE stock(
    id_stock SERIAL PRIMARY KEY,
    date_insert TIMESTAMP,
    id_article VARCHAR(20) REFERENCES article(id_article),
    id_magasin VARCHAR(10) REFERENCES magasin(id_magasin),
    prix_u FLOAT,
    quantite FLOAT DEFAULT 0
);
INSERT INTO stock(date_insert, id_article, id_magasin, prix_u) VALUES
    ('2023-10-10 12:00:00', 'NI001', 'MAG001', 2000),
    ('2023-10-10 12:00:00', 'NI001', 'MAG002', 1700),
    ('2023-10-10 12:00:00', 'NI001', 'MAG003', 2000),
    ('2023-10-10 12:00:00', 'NI002', 'MAG003', 1000),
    ('2023-10-10 12:00:00', 'NI003', 'MAG001', 900),
    ('2023-10-10 12:00:00', 'NI003', 'MAG002', 1100),
    ('2023-08-10 12:00:00', 'B001', 'MAG001', 40000),
    ('2023-08-10 12:00:00', 'B001', 'MAG002', 42500),
    ('2023-08-10 12:00:00', 'B002', 'MAG001', 50000),
    ('2023-08-10 12:00:00', 'B002', 'MAG002', 55000);


CREATE TABLE mouvement(
    id_mouvement SERIAL PRIMARY KEY,
    id_stock INTEGER REFERENCES stock(id_stock),
    prix_u FLOAT,
    date_mouvement TIMESTAMP,
    type VARCHAR(10),
    mouvement FLOAT,
    prix_mouvement FLOAT,
    quantite FLOAT DEFAULT 0,
    prix_quantite FLOAT
);

CREATE view v_stock AS
SELECT id_stock, date_insert, stk.id_article, stk.id_magasin, prix_u, quantite, article, description, famille, unite, type_sortie, magasin, emplacement FROM stock stk
    JOIN article art ON stk.id_article = art.id_article
    JOIN magasin mgs ON stk.id_magasin = mgs.id_magasin
    ORDER BY emplacement ASC, article ASC, id_stock ASC;

SELECT * FROM mouvement mvmt
    JOIN v_stock v_stk ON mvmt.id_stock=v_stk.id_stock;
