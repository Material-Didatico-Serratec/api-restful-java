package org.serratec.musicmanager.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="playlist")
public class PlayList {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playlist_sequence")
	@SequenceGenerator(name="playlist_sequence", sequenceName="seq_playlist", allocationSize = 1)
	@Column(name="pll_cd_id")
	private Long id;
	
	@NotNull
	@Column(name="pll_tx_nome", nullable = false, length=200)
	private String nome;
		
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	  name = "playlist_musica", 
	  joinColumns = @JoinColumn(name = "pll_cd_id"), 
	  inverseJoinColumns = @JoinColumn(name = "mus_cd_id"))
	private List<Musica> musicas;
	
	@ManyToOne
	@JoinColumn(name = "usu_cd_id")
	private Usuario usuario;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, musicas, nome, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayList other = (PlayList) obj;
		return Objects.equals(id, other.id) && Objects.equals(musicas, other.musicas)
				&& Objects.equals(nome, other.nome) && Objects.equals(usuario, other.usuario);
	}

}
