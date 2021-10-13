INSERT IGNORE INTO shops (shop_id,shop_name,shop_capacity) VALUES 
(1,'Joyeria Figueres', 7),
(2,'Joyeria Girona', 11);


INSERT IGNORE INTO pictures (picture_id,picture_author,picture_name,picture_price,shop_id) VALUES
(1,'Anonymous','Micracles7',30000,1),
(2,'El Latino','Catalunya 1003',270000,1),
(3,'G. Seurat','Tarde de domingo en la isla de la Grande Jatte',20500,1),
(4,'Anonymous','Musica del agua',53000,1),
(5,'Ofelia','John Everett Millais',83000,1),
(6,'Metropolis','George Grosz',10000,1),
(7,'Andrew Wyeth','Christina-s World',50000,2),
(8,'Vasili Kandinsky','Amsterdam-View from the Window',47000,2),
(9,'Caravaggio','La vocación de San Mateo',14000,2),
(10,'Miguel Ángel','La Capilla Sixtina',7000,2),
(11,'Renoir','Baile en el Moulin de la Galette',900000,2);