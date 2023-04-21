package org.serratec.musicmanager.dto;

import java.util.ArrayList;
import java.util.List;

import org.serratec.musicmanager.domain.Musica;
import org.serratec.musicmanager.domain.PlayList;

public class PlayListDTO {

	private Long id;
	private String nome;

	private List<Musica> musicas;

	public PlayListDTO() {
	}

	public PlayListDTO(PlayList playlist) {
		this.id = playlist.getId();
		this.nome = playlist.getNome();
		this.musicas = new ArrayList<>();
		for (Musica m : playlist.getMusicas()) {
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

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

}
