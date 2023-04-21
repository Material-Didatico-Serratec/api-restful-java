package org.serratec.musicmanager.dto;

import java.util.Objects;

import org.serratec.musicmanager.domain.Usuario;

public class UsuarioInsertDTO {
	private Long id;
	private String email;
	private String nome;
	private String senha;
	private String senhaConferir;
	private String perfilUsuario;
	
	public UsuarioInsertDTO() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPerfilUsuario() {
		return perfilUsuario;
	}
	public void setPerfilUsuario(String perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaConferir() {
		return senhaConferir;
	}

	public void setSenhaConferir(String senhaConferir) {
		this.senhaConferir = senhaConferir;
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
		UsuarioInsertDTO other = (UsuarioInsertDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
