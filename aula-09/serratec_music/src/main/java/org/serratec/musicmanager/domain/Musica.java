package org.serratec.musicmanager.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="musica")
public class Musica {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_musica")
	@SequenceGenerator(name = "sequence_musica", sequenceName = "seq_musica", allocationSize = 1)
	@Column(name="mus_cd_id")
	private Long id;
	
	@NotBlank
	@Column(name="mus_tx_titulo", nullable=false, length=200)
	private String titulo;
	
	@NotNull
	@Column(name="mus_nu_minuto", nullable=false)
	private Integer minutos;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getMinutos() {
		return minutos;
	}

	public void setMinutos(Integer minutos) {
		this.minutos = minutos;
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
		Musica other = (Musica) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
