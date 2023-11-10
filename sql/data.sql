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
    quantite FLOAT
);
INSERT INTO stock(date_insert, id_article, id_magasin, prix_u, quantite) VALUES
    ('2023-10-10 12:00:00', 'NI001', 'MAG001', 2000, 150),
    ('2023-10-10 12:00:00', 'NI001', 'MAG002', 1700, 175),
    ('2023-10-10 12:00:00', 'NI001', 'MAG003', 2000, 160),
    ('2023-10-10 12:00:00', 'NI002', 'MAG003', 1000, 150),
    ('2023-10-10 12:00:00', 'NI003', 'MAG001', 900, 100),
    ('2023-10-10 12:00:00', 'NI003', 'MAG002', 1100, 100),
    ('2023-08-10 12:00:00', 'B001', 'MAG001', 40000, 40),
    ('2023-08-10 12:00:00', 'B001', 'MAG002', 42500, 50),
    ('2023-08-10 12:00:00', 'B002', 'MAG001', 50000, 50),
    ('2023-08-10 12:00:00', 'B002', 'MAG002', 55000, 50);


CREATE TABLE history_stock(
    id_history_stock SERIAL PRIMARY KEY,
    id_stock INTEGER REFERENCES stock(id_stock),
    quantite_intiale FLOAT,
    prix_u FLOAT
);
INSERT INTO history_stock(id_stock, quantite_intiale, prix_u) VALUES
    (1, 2000, ),

CREATE TABLE mouvement(
    id_mouvement SERIAL PRIMARY KEY,
    date_mouvement TIMESTAMP,
    type VARCHAR(10),
    id_stock INTEGER REFERENCES stock(id_stock),
    mouvement FLOAT,
    prix_mouvement FLOAT,
    quantite FLOAT,
    prix_quantite FLOAT
);


