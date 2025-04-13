INSERT INTO unite (id_unite, nom, abrev ) VALUES
(  1, 'unité', 'u' ),
(  2, 'kilogramme', 'kg' ),
(  3, 'litre', 'l' );
ALTER TABLE unite  ALTER COLUMN id_unite  RESTART WITH 4;