package org.serratec.musicmanager.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.musicmanager.domain.Album;
import org.serratec.musicmanager.domain.Musica;

public class AlbumDTO {
	
	private Long id;
	private String nome;
	private Long idArtista;
	private String nomeArtista;
	private Integer minutos;
	
	private List<Musica> musicas;
	
	public AlbumDTO() {
	}
	public AlbumDTO(Album album) {
		this.id=album.getId();
		this.nome=album.getNome();
		this.idArtista=album.getArtista().getId();
		this.nomeArtista=album.getArtista().getNome();
		this.musicas = new ArrayList<>();
		this.minutos=0;
		for(Musica m: album.getMusicas()) {
			this.minutos+=m.getMinutos();
			musicas.add(m);
		}
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

	public Long getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Long idArtista) {
		this.idArtista = idArtista;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
	public Integer getMinutos() {
		return minutos;
	}
	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
	}
	
	
	

}
