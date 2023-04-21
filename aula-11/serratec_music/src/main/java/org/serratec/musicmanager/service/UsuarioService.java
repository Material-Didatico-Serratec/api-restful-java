package org.serratec.musicmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.musicmanager.domain.Usuario;
import org.serratec.musicmanager.dto.UsuarioDTO;
import org.serratec.musicmanager.dto.UsuarioInsertDTO;
import org.serratec.musicmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.qos.logback.core.encoder.Encoder;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional(readOnly = true)
	public List<UsuarioDTO> findAll(){
		List<Usuario> albuns = usuarioRepository.findAll();
		List<UsuarioDTO> dtos = new ArrayList<>();
		for(Usuario usuario:albuns) {
			dtos.add(new UsuarioDTO(usuario));
		}
		return dtos;
	}
	
	public UsuarioDTO findById(Long id) {
		Optional<Usuario> optUsuario = usuarioRepository.findById(id);
		if (optUsuario.isPresent()) {
			return new UsuarioDTO(optUsuario.get());
		}
		return null;
	}
	
	@Transactional
	public UsuarioDTO inserir(UsuarioInsertDTO usuarioDto) {
		
		if (usuarioDto.getSenha()!=null && !usuarioDto.getSenha().equals(usuarioDto.getSenhaConferir())) {
			throw new RuntimeException("Senhas Diferentes");
		}
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(encoder.encode(usuarioDto.getSenha()));
		usuario.setPerfilUsuario(usuarioDto.getPerfilUsuario());
		usuario = usuarioRepository.saveAndFlush(usuario);
		return new UsuarioDTO(usuario);
	}
	
	@Transactional
	public UsuarioDTO atualizar(Long id, UsuarioInsertDTO usuarioDto) {
		Optional<Usuario> opUsuario = usuarioRepository.findById(id);
		if (opUsuario.isEmpty()) {
			return null;
		}
		if (usuarioDto.getSenha()!=null && !usuarioDto.getSenha().equals(usuarioDto.getSenhaConferir())) {
			throw new RuntimeException("Senhas Diferentes");
		}
		Usuario usuarioBanco = opUsuario.get();
		usuarioBanco.setNome(usuarioDto.getNome());
		usuarioBanco.setEmail(usuarioDto.getEmail());
		if (usuarioDto.getSenha()!=null) {
			usuarioBanco.setSenha(encoder.encode(usuarioDto.getSenha()));
		}
		usuarioBanco.setPerfilUsuario(usuarioDto.getPerfilUsuario());
		return new UsuarioDTO(usuarioRepository.saveAndFlush(usuarioBanco));
	}
	
	public void apagar(Long id) {
		usuarioRepository.deleteById(id);
	}
	


}
