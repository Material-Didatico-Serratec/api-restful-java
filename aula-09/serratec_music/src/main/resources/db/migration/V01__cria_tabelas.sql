-- criacao de tabelas

CREATE TABLE artista (
	art_cd_id integer NOT NULL ,
	art_tx_nome varchar(100) NOT NULL,
	art_tx_tipo varchar(1) NOT NULL,
	PRIMARY KEY(art_cd_id)
);

CREATE TABLE album (
	alb_cd_id integer NOT NULL ,
	alb_tx_titulo varchar(200) NOT NULL,
	art_cd_id integer NOT NULL,
	PRIMARY KEY(alb_cd_id),
	FOREIGN KEY (art_cd_id) REFERENCES artista(art_cd_id)
);

CREATE TABLE musica (
  mus_cd_id integer NOT NULL ,
  mus_tx_titulo varchar(200) NOT NULL,
  mus_nu_minuto integer NOT NULL,
  PRIMARY KEY (mus_cd_id)
);

CREATE TABLE album_musica (
	mus_cd_id integer NOT NULL, 
	alb_cd_id integer NOT NULL,
	PRIMARY KEY (mus_cd_id, alb_cd_id),
	FOREIGN KEY (mus_cd_id) REFERENCES musica(mus_cd_id),
	FOREIGN KEY (alb_cd_id) REFERENCES album(alb_cd_id)
);

-- criacao de sequences

CREATE SEQUENCE seq_artista ;
CREATE SEQUENCE seq_album ;
CREATE SEQUENCE seq_musica ;
