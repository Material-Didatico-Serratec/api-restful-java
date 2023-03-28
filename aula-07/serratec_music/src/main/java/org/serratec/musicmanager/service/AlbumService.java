package org.serratec.musicmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.musicmanager.domain.Album;
import org.serratec.musicmanager.dto.AlbumDTO;
import org.serratec.musicmanager.dto.AlbumSimplesDTO;
import org.serratec.musicmanager.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;

	@Transactional(readOnly = true)
	public List<AlbumDTO> findAll(){
		List<Album> albuns = albumRepository.findAll();
		List<AlbumDTO> dtos = new ArrayList<>();
		for(Album album:albuns) {
			dtos.add(new AlbumDTO(album));
		}
		return dtos;
	}
	
	public List<AlbumSimplesDTO> findAllSimples(){
		return albumRepository.buscaSimples();
	}
	
	public AlbumDTO findById(Long id) {
		Optional<Album> optAlbum = albumRepository.findById(id);
		if (optAlbum.isPresent()) {
			return new AlbumDTO(optAlbum.get());
		}
		return null;
	}
	
	@Transactional
	public AlbumDTO inserir(Album album) {
		return new AlbumDTO( albumRepository.save(album));
	}
	
	@Transactional
	public AlbumDTO atualizar(Long id, Album album) {
		Optional<Album> opAlbum = albumRepository.findById(id);
		if (opAlbum.isEmpty()) {
			return null;
		}
		Album albumBanco = opAlbum.get();
		albumBanco.setNome(album.getNome());
		albumBanco.setMusicas(album.getMusicas());
		return new AlbumDTO(albumRepository.save(albumBanco));
	}
	
	public void apagar(Long id) {
		albumRepository.deleteById(id);
	}


}
