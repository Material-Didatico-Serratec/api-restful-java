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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_album")
	@SequenceGenerator(name = "sequence_album", sequenceName = "seq_album", allocationSize = 1)
	@Column(name="alb_cd_id")
	private Long id;
	
	@NotBlank
	@Column(name="alb_tx_titulo", length=200, nullable=false)
	private String nome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="art_cd_id")
	private Artista artista;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "album_musica", 
	joinColumns = @JoinColumn(name="alb_cd_id"),
	inverseJoinColumns = @JoinColumn(name="mus_cd_id"))
	private List<Musica> musicas;

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

	
	
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
