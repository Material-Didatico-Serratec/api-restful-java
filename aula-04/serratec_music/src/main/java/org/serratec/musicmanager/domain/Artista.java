package org.serratec.musicmanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.serratec.musicmanager.enums.TipoArtistaEnum;

@Entity
@Table(name = "artista")
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=5, max=100)
	@Column(name="nome", length = 100, nullable = false)
	private String nome;
	
	@NotNull(message = "Tipo de Artista deve ser selecionado")
	@Column(name="tipo_artista", length=1, nullable=false)
	private TipoArtistaEnum tipoArtista;
	
	
	public Artista(Long id, String nome, TipoArtistaEnum tipoArtista) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoArtista = tipoArtista;
	}
	public Artista() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public TipoArtistaEnum getTipoArtista() {
		return tipoArtista;
	}
	public void setTipoArtista(TipoArtistaEnum tipoArtista) {
		this.tipoArtista = tipoArtista;
	}
	
	

}
