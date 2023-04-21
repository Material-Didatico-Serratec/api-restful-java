package org.serratec.musicmanager.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.serratec.musicmanager.domain.Capa;
import org.serratec.musicmanager.dto.AlbumDTO;
import org.serratec.musicmanager.dto.AlbumSimplesDTO;
import org.serratec.musicmanager.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("/{id}/capa")
	public ResponseEntity<byte[]> buscaCapa(@PathVariable Long id) {
		AlbumDTO album = albumService.findById(id);
		Capa capa = albumService.getCapa(id);
		if (capa!=null) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_TYPE, capa.getMimetype());
			headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(capa.getData().length));
			MimeType mimeType = MimeType.valueOf(capa.getMimetype());
			String nomeArquivo = album.getNome() + "."+ mimeType.getSubtype();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" +nomeArquivo);
			headers.add(HttpHeaders.CACHE_CONTROL, "no-cache");
			return new ResponseEntity<>(capa.getData(), headers, HttpStatus.OK);
			
		} else {
			return (ResponseEntity<byte[]>) ResponseEntity.notFound();
		}
		
	}

	@PostMapping
	public AlbumDTO insere(@RequestParam("file") MultipartFile file,   @Valid @RequestPart("album") AlbumDTO album ) throws IOException {
		return albumService.inserir(file, album);
			
	}
	
	@PutMapping("/{id}")
	public AlbumDTO atualiza(@RequestParam("file") MultipartFile file,   @Valid @RequestPart("album") AlbumDTO album, @PathVariable Long id) throws IOException {
		return albumService.atualizar(id,file, album);
	}

	@DeleteMapping("/{id}")
	public void apagar(@PathVariable Long id) {
		albumService.apagar(id);
	}

}
