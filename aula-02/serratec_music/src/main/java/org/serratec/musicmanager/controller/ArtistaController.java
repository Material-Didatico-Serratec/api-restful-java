package org.serratec.musicmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.musicmanager.domain.Artista;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artista")
public class ArtistaController {
	private List<Artista> artistas = new ArrayList();
	public ArtistaController() {
		artistas.add(new Artista(1l, "Michael Jackson", "S"));
		artistas.add(new Artista(2l, "Pink Floyd", "B"));
		artistas.add(new Artista(3l, "Legião Urbana", "B"));
		artistas.add(new Artista(4l, "Robero Carlos", "S"));
	}
	

	@GetMapping
	public List<Artista> listaTodos(){
		return artistas;
	}
	
	@GetMapping("/{id}")
	public Artista busca(@PathVariable Long id) {
		for(int i = 0; i<artistas.size(); i++) {
			Artista artista = artistas.get(i);
			if (artista.getId().equals(id)) {
				return artista;
			}
		}
		return null;
	}

	@PostMapping
	public Artista insere(@RequestBody Artista artista) {
			artista.setId((long) (artistas.size()+1));
			artistas.add(artista);
			return artista;
	}
	
	@PutMapping("/{id}")
	public Artista atualiza(@RequestBody Artista artista, @PathVariable Long id) {
		for(int i = 0; i<artistas.size(); i++) {
			Artista artistaLista = artistas.get(i);
			if (artistaLista.getId().equals(id)) {
				artistaLista.setNome(artista.getNome());
				artistaLista.setTipoArtista(artista.getTipoArtista());
				return artistaLista;
			}
		}
		return null;
		
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		for(int i = 0; i<artistas.size(); i++) {
			Artista artistaLista = artistas.get(i);
			if (artistaLista.getId().equals(id)) {
				artistas.remove(i);
				return;
			}
		}
	}

}
