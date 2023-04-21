package org.serratec.musicmanager.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.serratec.musicmanager.dto.PlayListDTO;
import org.serratec.musicmanager.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playList")
public class PlayListController {

	@Autowired
	private PlayListService playListService;
	

	@GetMapping
	public List<PlayListDTO> listaTodos(){
		return playListService.findAll();
	}
	
	@GetMapping("/{id}")
	public PlayListDTO busca(@PathVariable Long id) {
		return playListService.findById(id);
		
	}
	

	@PostMapping
	public PlayListDTO insere(@Valid @RequestPart("playList") PlayListDTO playList ) throws IOException {
		return playListService.inserir(playList);
			
	}
	
	@PutMapping("/{id}")
	public PlayListDTO atualiza( @Valid @RequestBody PlayListDTO playList, @PathVariable Long id) throws IOException {
		return playListService.atualizar(id,playList);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		playListService.apagar(id);
	}

}
