CREATE TABLE album_capa (
	alb_cd_id integer NOT NULL,
	alc_tx_media_type varchar(200) NOT NULL,
	alc_bl_capa blob NOT NULL,
	PRIMARY key(alb_cd_id),
	FOREIGN KEY (alb_cd_id) REFERENCES album(alb_cd_id)
);


INSERT INTO album_capa (alb_cd_id, alc_tx_media_type, alc_bl_capa) VALUES 
 (1, 'image/jpeg', FILE_READ('classpath:capas/Michael_Jackson-Thriller.jpg')),
 (2, 'image/jpeg', FILE_READ('classpath:capas/Michael_Jackson-Off_the_Wall.jpg')),
 (3, 'image/jpeg', FILE_READ('classpath:capas/Legião_Urbana-Dois.jpg')),
 (4, 'image/jpeg', FILE_READ('classpath:capas/Legião_Urbana-Que_País_É_Este.jpg')),
 (5, 'image/png',  FILE_READ('classpath:capas/Beyoncé_Homecoming_The_Live_Album.png')),
 (6, 'image/png',  FILE_READ('classpath:capas/Beyoncé_-_Beyoncé.png')),
 (7, 'image/png',  FILE_READ('classpath:capas/BTS_-_Map_of_the_Soul_7.png')),
 (8, 'image/png',  FILE_READ('classpath:capas/BTS-Be.png'));


