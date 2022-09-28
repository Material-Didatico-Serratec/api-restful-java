package org.serratec.musicmanager.domain;

public class Artista {
	
	private Long id;
	private String nome;
	private String tipoArtista;
	
	
	public Artista(Long id, String nome, String tipoArtista) {
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
	public String getTipoArtista() {
		return tipoArtista;
	}
	public void setTipoArtista(String tipoArtista) {
		this.tipoArtista = tipoArtista;
	}
	
	

}
