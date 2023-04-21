-- inserir michael jackson e 2 albuns

INSERT INTO artista (art_cd_id, art_tx_nome, art_tx_tipo) VALUES
 (1, 'Michael Jackson', 'S');
 
INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES 
  (1, 1, 'Triller');
  
INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
  (1, 'Wanna Be Startin'' Somethin''', 6),
  (2, 'Baby Be Mine', 5),
  (3, 'The Girl is Mine', 4),
  (4, 'Thriller', 6),
  (5, 'Beat It', 4),
  (6, 'Billie Jean', 5),
  (7, 'Human Nature', 4),
  (8, 'P.Y.T. (Pretty Young Thing', 4),
  (9, 'The Lady In My Life', 5);
  
INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (1, 1), (1,2), (1, 3), (1,4), (1,5), (1,6), (1,7), (1,8), (1,9);     
   

INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES 
  (2, 1, 'Off the Wall');
   
INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
 (10, 'Don''t Stop ''Til You Get Enough',6 ),
 (11, 'Rock With You', 4),
 (12, 'Workin'' Day and Night',5),
 (13, 'Get on the Floor', 5),
 (14, 'Off the Wall', 4),
 (15, 'Girlfriend',3),
 (16, 'She''s Out of My Life',4),
 (17, 'I Can''t Help It',4),
 (18, 'It''s The Faling in Love',4),
 (19, 'Burn This Disco Out',4);

INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (2, 10), (2, 11), (2, 12), (2, 13), (2, 14), (2, 15), (2, 16), (2, 17), (2, 18), (2, 19);   
   
-- inserir legião urbana e 2 albuns   
 
INSERT INTO artista (art_cd_id, art_tx_nome, art_tx_tipo) VALUES
 (2, 'Legião Urbana', 'B');
 
INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES
  (3, 2, 'Dois');
  
INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
 (20, 'Daniel Na Cova Dos Leões', 4),
 (21, 'Quase Sem Querer', 5),
 (22, 'Acrilic On Canvas', 5),
 (23, 'Eduardo E Monica', 5),
 (24, 'Central Do Brasil', 2),
 (25, 'Tempo Perdido', 5),
 (26, 'Metrópole', 3),
 (27, 'Plantas Embaixo do Aquário', 3),
 (28, 'Música Urbana 2', 3),
 (29, 'Andrea Doria',5),
 (30, 'Fábrica', 5),
 (31, 'Química', 3);

INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (3, 20), (3, 21), (3, 22), (3, 23), (3, 24), (3, 25), (3, 26), (3, 27), (3, 28), (3, 29), (3, 30), (3, 31);   

INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES
  (4, 2, 'Que Pais É Esse');
 
INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
 (32, 'Que País É Este', 3),
 (33, 'Conexão Amazônica', 5),
 (34, 'Tédio (Com um T Bem Grande Pra Você', 3),
 (35, 'Depois Do Começo', 3),
 (36, 'Química', 2),
 (37, 'Eu Sei', 3),
 (38, 'Faroeste Caboclo', 9),
 (39, 'Angra Dos Reis', 5),
 (40, 'Mais do Mesmo', 3);
 
 INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (4, 32), (4, 33), (4, 34), (4, 35), (4, 36), (4, 37), (4, 38), (4, 39), (4, 40);
   
-- inserir Beyonce e 2 albuns
 
 
 INSERT INTO artista (art_cd_id, art_tx_nome, art_tx_tipo) VALUES
 (3, 'Beyoncé', 'S');
 
INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES
  (5, 3, 'Homecoming: The Live Album');


INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
 (41, 'Welcome (Homecoming Live)', 3),
 (42, 'Crazy in Love (Homecoming Live)', 3),
 (43, 'Freedom (Homecoming Live)', 2),
 (44, 'Lift Ev''ry Voice and Sing (Homecoming Live)', 2),
 (45, 'Formation (Homecoming Live)', 4),
 (46, 'So Much Damn Swag (Interlude: Homecoming Live', 1),
 (47, 'Sorry (Homecoming Live)', 7),
 (48, 'Kitty Kat (Homecoming Live)', 1),
 (49, 'Bow Down (Homecoming Live)', 2),
 (50, 'I Been On (Homecoming Live)', 3),
 (51, 'Drunk in Love (Homecoming Live)', 4),
 (52, 'Diva (Homecoming Live)', 3),
 (53, 'Flawless / Feeling Myself (Homecoming Live)', 4),
 (54, 'Top Off (Homecoming Live)', 2),
 (55, '7/11 (Homecoming Live)', 3),
 (56, 'Bug a Boo Roll Call (Interlude: Homecoming Live)', 2),
 (57, 'Party (Homecoming Live)', 4),
 (58, 'Don''t Hurt Yourself (Homecoming Live)', 4),
 (59, 'I Care (Homecoming Live)', 4),
 (60, 'Partition (Homecoming Live)', 4),
 (61, 'Yoncé (Homecoming Live)', 4),
 (62, 'Mi Gente (Homecoming Live)', 4),
 (63, 'Baby Boy (Homecoming Live)', 2),
 (64, 'You Don''t Love Me (No, No, No) [Homecoming Live]', 1),
 (65, 'Hold Up (Homecoming Live)', 1),
 (66, 'Countdown (Homecoming Live)', 2),
 (67, 'Check on It (Homecoming Live)', 1),
 (68, 'Deja Vu (Homecoming Live)', 5),
 (69, 'The Bzzzz Drumline (Interlude: Homecoming Live)', 3),
 (70, 'Run the World (Girls) [Homecoming Live]', 4),
 (71, 'Lose My Breath (Homecoming Live)', 2),
 (72, 'Say My Name (Homecoming Live)', 2),
 (73, 'Soldier (Homecoming Live)', 2),
 (74, 'Get Me Bodied (Homecoming Live)', 4),
 (75, 'Single Ladies (Put a Ring on It) [Homecoming Live]', 3),
 (76, 'Lift Ev''ry Voice and Sing (Blue''s Version: Homecoming Live)', 2),
 (77, 'Love on Top (Homecoming Live)', 4),
 (78, 'Shining (Thank You) [Homecoming Live]', 3),
 (79, 'Before I Let Go (Homecoming Live Bonus Track)', 4),
 (80, 'I Been On (Homecoming Live Bonus Track', 2);
 
INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (5, 41),(5, 42),(5, 43),(5, 44),(5, 45),(5, 46),(5, 47),(5, 48),(5, 49),(5, 50),
   (5, 51),(5, 52),(5, 53),(5, 54),(5, 55),(5, 56),(5, 57),(5, 58),(5, 59),(5, 60),
   (5, 61),(5, 62),(5, 63),(5, 64),(5, 65),(5, 66),(5, 67),(5, 68),(5, 69),(5, 70),
   (5, 71),(5, 72),(5, 73),(5, 74),(5, 75),(5, 76),(5, 77),(5, 78),(5, 79),(5, 80);

     
INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES
  (6, 3, 'Beyoncé'); 

  INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
 (81, 'Pretty Hurts', 4),
 (82, 'Haunted - Album Version [Explicit]', 6),
 (83, 'Drunk in Love [Explicit', 5),
 (84, 'Blow', 5),
 (85, 'No Angel', 4),
 (86, 'Partition [Explicit]', 5),
 (87, 'Jealous', 3),
 (88, 'Rocket [Explicit]', 6),
 (89, 'Mine [Explicit]', 6),
 (90, 'XO', 3),
 (91, '***Flawless [Explicit]', 4),
 (92, 'Superpower', 5),
 (93, 'Heaven', 4),
 (94, 'Blue', 4);

INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (6, 81), (6, 82), (6, 83), (6, 84), (6, 85), (6, 86), (6, 87), (6, 88), (6, 89), (6, 90),
   (6, 91), (6, 92), (6, 93), (6, 94);
   
   
-- inserir BTS e 2 albuns

 
INSERT INTO artista (art_cd_id, art_tx_nome, art_tx_tipo) VALUES
 (4, 'BTS', 'B');


INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES
  (7, 4, 'Map of the Soul: 7');
  
INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
 (95, 'Intro : Persona', 3),
 (96, 'Boy With Luv', 4),
 (97, 'Make It Right', 4),
 (98, 'Jamais Vu', 4),
 (99, 'Dionysus', 4),
 (100, 'Interlude : Shadow', 4),
 (101, 'Black Swan', 3),
 (102, 'Filter', 3),
 (103, 'My Time', 4),
 (104, 'Louder than bombs', 4),
 (105, 'ON', 4),
 (106, 'UGH!', 4),
 (107, '00:00 (Zero O''Clock)', 4),
 (108, 'Inner Child', 4),
 (109, 'Friends', 3),
 (110, 'Moon', 3),
 (111, 'Respect', 4),
 (112, 'We are Bulletproof : the Eternal', 4),
 (113, 'Outro : Ego', 3);
 
INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (7, 95),(7, 96),(7, 97),(7, 98),(7, 99),(7, 100),
   (7, 101),(7, 102),(7, 103),(7, 104),(7, 105),(7, 106),(7, 107),(7, 108),(7, 109),
   (7, 110),(7, 111),(7, 112),(7, 113);
   
   

INSERT INTO album (alb_cd_id, art_cd_id, alb_tx_titulo) VALUES
  (8, 4, 'Be');
   
INSERT INTO musica (mus_cd_id, mus_tx_titulo, mus_nu_minuto) VALUES 
 (114, 'Life Goes On', 3),
 (115, 'Fly to My Room', 4), 
 (116, 'Blue & Grey', 4), 
 (117, 'Skit', 3), 
 (118, 'Telepathy', 3), 
 (119, 'Dis-ease', 4), 
 (120, 'Stay', 3), 
 (121, 'Dynamite', 3);
 
INSERT INTO album_musica (alb_cd_id, mus_cd_id) VALUES 
   (8, 114), (8, 115), (8, 116), (8, 117), (8, 118), (8, 119), (8, 120), (8, 121);  
   
ALTER SEQUENCE seq_artista RESTART WITH 2000 INCREMENT BY 10;
ALTER SEQUENCE seq_album   RESTART WITH 1000 INCREMENT BY 10;
ALTER SEQUENCE seq_musica  RESTART WITH 1000 INCREMENT BY 10;
