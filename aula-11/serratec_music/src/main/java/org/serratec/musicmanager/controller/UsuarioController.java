package org.serratec.musicmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.musicmanager.dto.UsuarioDTO;
import org.serratec.musicmanager.dto.UsuarioInsertDTO;
import org.serratec.musicmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public List<UsuarioDTO> listaTodos(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/{id}")
	public UsuarioDTO busca(@PathVariable Long id) {
		return usuarioService.findById(id);
		
	}

	@PostMapping
	public UsuarioDTO insere(@Valid @RequestBody UsuarioInsertDTO usuario) {
		return usuarioService.inserir(usuario);
			
	}
	
	@PutMapping("/{id}")
	public UsuarioDTO atualiza(@Valid @RequestBody UsuarioInsertDTO usuario, @PathVariable Long id) {
		return usuarioService.atualizar(id, usuario);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		usuarioService.apagar(id);
	}

}
