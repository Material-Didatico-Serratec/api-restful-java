package org.serratec.musicmanager.security;

import java.util.Optional;

import org.serratec.musicmanager.domain.Usuario;
import org.serratec.musicmanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDetalheService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Usuario> opUsuario = usuarioRepository.findByEmail(username);
		if (opUsuario.isEmpty()) {
			throw new UsernameNotFoundException("Login " + username + " nao existe!");
		}
		
		return new UsuarioDetalhe(opUsuario.get());
	}

}
