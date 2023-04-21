CREATE TABLE usuario (
	usu_cd_id integer NOT NULL,
	usu_tx_email varchar(200) NOT NULL,
	usu_tx_nome varchar(100) NOT NULL,
	usu_tx_senha varchar(200) NOT NULL,
	usu_tx_perfil varchar(20) NOT NULL,
	PRIMARY KEY (usu_cd_id)
);

CREATE UNIQUE INDEX idx_usuario_email ON usuario(usu_tx_email);

CREATE SEQUENCE seq_usuario ;

ALTER SEQUENCE seq_usuario RESTART WITH 2000 INCREMENT BY 10;

--- senhas 123456 geradas no site  https://bcrypt-generator.com/ 

INSERT INTO usuario (usu_cd_id, usu_tx_email, usu_tx_nome, usu_tx_senha, usu_tx_perfil) VALUES 
  (1, 'admin@admin.com', 'Admnistrador', '$2a$12$NpbAWeqtfUvIYdCCdG1pi./qJyT1ERoz0VWJg04OAoC2I1H9WblsG', 'ROLE_ADMIN'),
  (2, 'user1@user.com', 'Usuário 1', '$2a$12$LuRRvJ5sfJbB63OIntVvouClIIIeJb64qIbr8AIyLQWxNg7.AI73u', 'ROLE_USER'),
  (3, 'user2@user.com', 'Usuário 2', '$2a$12$Hfg6IlZN0fr81xL1hcqWQe4/U6NjxGAcE8nsDfrGYO6/8Tw89rTw.', 'ROLE_USER');
  

CREATE TABLE playlist (
   pll_cd_id integer NOT NULL,
   pll_tx_nome varchar(200),
   usu_cd_id integer NOT NULL,
   PRIMARY key(pll_cd_id),
   FOREIGN KEY (usu_cd_id) REFERENCES usuario(usu_cd_id)
);

CREATE TABLE playlist_musica (
	pll_cd_id integer NOT NULL,
	mus_cd_id integer NOT NULL, 
	PRIMARY KEY (pll_cd_id,mus_cd_id ),
	FOREIGN KEY (pll_cd_id) REFERENCES playlist(pll_cd_id),
	FOREIGN KEY (mus_cd_id) REFERENCES musica(mus_cd_id)
);


CREATE SEQUENCE seq_playlist;
