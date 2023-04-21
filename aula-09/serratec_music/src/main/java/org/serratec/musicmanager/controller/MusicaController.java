package org.serratec.musicmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.musicmanager.domain.Musica;
import org.serratec.musicmanager.repository.MusicaRepository;
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
@RequestMapping("/musica")
public class MusicaController {

	@Autowired
	private MusicaRepository musicaRepository;
	

	@GetMapping
	public List<Musica> listaTodos(){
		return musicaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Musica busca(@PathVariable Long id) {
		return musicaRepository.findById(id).get();
		
	}

	@PostMapping
	public Musica insere(@Valid @RequestBody Musica musica) {
		return musicaRepository.save(musica);
			
	}
	
	@PutMapping("/{id}")
	public Musica atualiza(@Valid @RequestBody Musica musica, @PathVariable Long id) {
		Optional<Musica> opMusica = musicaRepository.findById(id);
		if (opMusica.isEmpty()) {
			return null;
		}
		Musica musicaBanco = opMusica.get();
		musicaBanco.setTitulo(musica.getTitulo());
		musicaBanco.setMinutos(musica.getMinutos());
		return musicaRepository.save(musicaBanco);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		musicaRepository.deleteById(id);
	}

}
