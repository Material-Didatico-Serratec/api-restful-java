package org.serratec.musicmanager.controller;

import java.util.List;

import javax.validation.Valid;

import org.serratec.musicmanager.domain.Album;
import org.serratec.musicmanager.dto.AlbumDTO;
import org.serratec.musicmanager.dto.AlbumSimplesDTO;
import org.serratec.musicmanager.service.AlbumService;
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
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;
	

	@GetMapping
	public List<AlbumDTO> listaTodos(){
		return albumService.findAll();
	}
	@GetMapping("/simples")
	public List<AlbumSimplesDTO> listaTodosSimples(){
		return albumService.findAllSimples();
	}
	
	@GetMapping("/{id}")
	public AlbumDTO busca(@PathVariable Long id) {
		return albumService.findById(id);
		
	}

	@PostMapping
	public AlbumDTO insere(@Valid @RequestBody Album album) {
		return albumService.inserir(album);
			
	}
	
	@PutMapping("/{id}")
	public AlbumDTO atualiza(@Valid @RequestBody Album album, @PathVariable Long id) {
		return albumService.atualizar(id, album);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		albumService.apagar(id);
	}

}
