
-------
-- type_plat
-------

INSERT INTO type_plat (id_type_plat, nom, rang ) VALUES
(1, 'Dessert', 3),
(2, 'Plat principal', 2),
(3, 'Entrée', 1);

ALTER TABLE type_plat   ALTER COLUMN id_type_plat  RESTART WITH 4;


-------
-- plat
-------

-- 30 Entrées (id_plat 1 à 30)
INSERT INTO plat (id_plat, nom, nb_personnes, cout, id_type_plat) VALUES
(1,  'Salade de quinoa aux légumes',           4, 12.50, 3),
(2,  'Salade de tomates et basilic',           4, 12.00, 3),
(3,  'Soupe froide de concombre',              4, 11.50, 3),
(4,  'Velouté de carottes et gingembre',       4, 11.00, 3),
(5,  'Salade d’asperges et pois',              4, 12.00, 3),
(6,  'Taboulé aux herbes fraîches',            4, 10.50, 3),
(7,  'Carpaccio de betterave et orange',       4, 13.00, 3),
(8,  'Salade de roquette et noix',             4, 12.50, 3),
(9,  'Salade de lentilles et carottes râpées', 4, 11.50, 3),
(10, 'Salade de pois cassés',                  4, 11.00, 3),
(11, 'Salade de fenouil et agrumes',           4, 12.00, 3),
(12, 'Salade de concombre, menthe et yaourt',     4, 12.50, 3),
(13, 'Salade de radis et citron',              4, 11.50, 3),
(14, 'Salade de pois chiches, tomates et concombre', 4, 12.00, 3),
(15, 'Soupe de courgettes à la menthe',        4, 12.50, 3),
(16, 'Salade de betteraves et feta',           4, 12.00, 3),
(17, 'Soupe de légumes verts',                 4, 11.50, 3),
(18, 'Salade de haricots verts et tomates séchées', 4, 12.00, 3),
(19, 'Soupe de poivrons grillés',              4, 11.50, 3),
(20, 'Salade de courgettes crues et parmesan', 4, 12.50, 3),
(21, 'Salade de cresson aux agrumes',          4, 12.00, 3),
(22, 'Soupe froide de melon et menthe',        4, 12.50, 3),
(23, 'Salade de carottes râpées et raisins secs', 4, 11.50, 3),
(24, 'Soupe de radis et pomme',                4, 11.00, 3),
(25, 'Salade de chou rouge et pomme verte',    4, 12.00, 3),
(26, 'Salade de petits pois et menthe',        4, 11.50, 3),
(27, 'Soupe de brocoli froid',                 4, 12.00, 3),
(28, 'Salade de courgette et menthe',          4, 11.50, 3),
(29, 'Velouté d’aubergine froide',             4, 12.00, 3),
(30, 'Salade de poivrons colorés',             4, 12.50, 3);

-- 50 Plats principaux (id_plat 31 à 80)
INSERT INTO plat (id_plat, nom, nb_personnes, cout, id_type_plat) VALUES
(31, 'Ratatouille',                            4, 12.50, 2),
(32, 'Quiche aux légumes',                     4, 12.50, 2),
(33, 'Lasagnes végétariennes',                 4, 13.00, 2),
(34, 'Curry de légumes',                       4, 11.50, 2),
(35, 'Chili sin carne',                        4, 12.00, 2),
(36, 'Tofu sauté aux légumes',                 4, 12.50, 2),
(37, 'Burger végétarien aux haricots noirs',   4, 13.00, 2),
(38, 'Pâtes aux épinards et ricotta',          4, 12.50, 2),
(39, 'Falafels',                               4, 11.00, 2),
(40, 'Couscous aux légumes',                   4, 13.00, 2),
(41, 'Soupe de lentilles corail',              4, 11.50, 2),
(42, 'Tian de légumes',                        4, 12.00, 2),
(43, 'Gnocchis à la sauce tomate',             4, 12.50, 2),
(44, 'Pâtes au pesto de basilic',              4, 13.00, 2),
(45, 'Galettes de légumes',                    4, 11.50, 2),
(46, 'Wrap aux légumes grillés',               4, 12.00, 2),
(47, 'Moussaka végétarienne',                  4, 13.50, 2),
(48, 'Pizza aux légumes',                      4, 14.00, 2),
(49, 'Gratin de courgettes et tomates',        4, 12.50, 2),
(50, 'Poivrons farcis au riz',                 4, 13.00, 2),
(51, 'Tajine de légumes',                      4, 13.50, 2),
(52, 'Pâtes primavera',                        4, 12.00, 2),
(53, 'Salade de pois chiches et tomates',      4, 11.50, 2),
(54, 'Curry de pois chiches (Chana Masala)',   4, 12.00, 2),
(55, 'Buddha bowl aux légumes',                4, 13.00, 2),
(56, 'Risotto aux champignons',                4, 14.00, 2),
(57, 'Crêpes aux épinards et ricotta',         4, 12.50, 2),
(58, 'Pâtes à la puttanesca végétarienne',     4, 13.00, 2),
(59, 'Boulettes de lentilles',                 4, 12.00, 2),
(60, 'Salade de pâtes méditerranéenne',        4, 12.50, 2),
(61, 'Tofu mariné grillé',                     4, 13.00, 2),
(62, 'Soupe minestrone',                       4, 12.00, 2),
(63, 'Curry de lentilles (Dal)',               4, 11.50, 2),
(64, 'Tempura de légumes',                     4, 12.50, 2),
(65, 'Sandwich au houmous et légumes',         4, 11.00, 2),
(66, 'Curry thaï de légumes',                  4, 13.00, 2),
(67, 'Gratin dauphinois végétarien',           4, 12.50, 2),
(68, 'Pâtes à la crème de poivrons',           4, 13.00, 2),
(69, 'Curry de tofu et légumes',               4, 12.50, 2),
(70, 'Brochettes de légumes grillés',          4, 13.00, 2),
(71, 'Burger de haricots rouges',              4, 12.00, 2),
(72, 'Gaspacho andalou',                       4, 11.50, 2),
(73, 'Gratin de chou-fleur',                   4, 12.50, 2),
(74, 'Tagliatelles aux champignons',           4, 13.00, 2),
(75, 'Poêlée de légumes méditerranéens',       4, 12.50, 2),
(76, 'Ragoût de légumes',                      4, 13.00, 2),
(77, 'Curry d’aubergines',                     4, 12.50, 2),
(78, 'Salade de légumes rôtis',                4, 12.00, 2),
(79, 'Galettes de quinoa',                     4, 12.50, 2),
(80, 'Tofu à l’asiatique',                     4, 13.00, 2);

-- 20 Desserts (id_plat 81 à 100)
INSERT INTO plat (id_plat, nom, nb_personnes, cout, id_type_plat) VALUES
(81, 'Salade de fruits frais',                4, 10.00, 1),
(82, 'Mousse au chocolat végétalienne',       4, 11.50, 1),
(83, 'Brownies végétaliens',                  4, 12.00, 1),
(84, 'Tarte aux pommes végétarienne',         4, 12.50, 1),
(85, 'Crumble aux fruits rouges',             4, 11.50, 1),
(86, 'Gâteau à l''orange',                    4, 12.00, 1),
(87, 'Cheesecake végétalien',                 4, 13.00, 1),
(88, 'Panna cotta au lait de coco',           4, 12.50, 1),
(89, 'Glace à la banane',                     4, 11.00, 1),
(90, 'Sorbet à la mangue',                    4, 11.50, 1),
(91, 'Tiramisu végétarien',                   4, 12.00, 1),
(92, 'Clafoutis aux cerises',                 4, 12.50, 1),
(93, 'Moelleux au chocolat',                  4, 13.00, 1),
(94, 'Macarons végétaliens',                  4, 12.00, 1),
(95, 'Compote de poires épicée',              4, 11.50, 1),
(96, 'Biscotti aux amandes',                  4, 12.00, 1),
(97, 'Flan végétal',                          4, 11.50, 1),
(98, 'Salade de fruits exotiques',            4, 11.00, 1),
(99, 'Gaufres végétariennes aux fruits',      4, 12.50, 1),
(100, 'Crème brûlée végétalienne',            4, 13.00, 1);

ALTER TABLE plat        ALTER COLUMN id_plat       RESTART WITH 101;
