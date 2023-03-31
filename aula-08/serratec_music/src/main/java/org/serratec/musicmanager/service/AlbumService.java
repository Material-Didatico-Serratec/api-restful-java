package org.serratec.musicmanager.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.musicmanager.domain.Album;
import org.serratec.musicmanager.domain.Artista;
import org.serratec.musicmanager.domain.Capa;
import org.serratec.musicmanager.domain.Musica;
import org.serratec.musicmanager.dto.AlbumDTO;
import org.serratec.musicmanager.dto.AlbumSimplesDTO;
import org.serratec.musicmanager.repository.AlbumRepository;
import org.serratec.musicmanager.repository.CapaRepository;
import org.serratec.musicmanager.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AlbumService {
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private MusicaRepository musicaRepository;
	
	@Autowired
	private CapaRepository capaRepository;

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
	public AlbumDTO inserir(MultipartFile file, AlbumDTO albumDto) throws IOException {
		Album album = new Album();
		album.setArtista(new Artista());
		album.getArtista().setId(albumDto.getIdArtista());
		album.setNome(albumDto.getNome());
		album.setMusicas(new ArrayList());
		for(Musica musica: albumDto.getMusicas()) {
			if (musica.getId()!=null) {
				Optional<Musica> opMusica = musicaRepository.findById(musica.getId());
				if (opMusica.isPresent()) {
					album.getMusicas().add(opMusica.get());
				}
			} else {
				Musica musicaNova = new Musica();
				musicaNova.setTitulo(musica.getTitulo());
				musicaNova.setMinutos(musica.getMinutos());
				musicaNova = musicaRepository.save(musicaNova);
				album.getMusicas().add(musicaNova);
			}
		}
		album = albumRepository.saveAndFlush(album);
		Capa capa = new Capa();
		capa.setData(file.getBytes());
		capa.setMimetype(file.getContentType());
		capa.setId(album.getId());
		capaRepository.save(capa);
		return new AlbumDTO(album);
	}
	
	@Transactional
	public AlbumDTO atualizar(Long id, MultipartFile file, AlbumDTO albumDto) throws IOException {
		Optional<Album> opAlbum = albumRepository.findById(id);
		if (opAlbum.isEmpty()) {
			return null;
		}
		Album albumBanco = opAlbum.get();
		albumBanco.setNome(albumDto.getNome());
		albumBanco.setMusicas(new ArrayList());
		for(Musica musica: albumDto.getMusicas()) {
			if (musica.getId()!=null) {
				Optional<Musica> opMusica = musicaRepository.findById(musica.getId());
				if (opMusica.isPresent()) {
					albumBanco.getMusicas().add(opMusica.get());
				}
			} else {
				Musica musicaNova = new Musica();
				musicaNova.setTitulo(musica.getTitulo());
				musicaNova.setMinutos(musica.getMinutos());
				musicaNova = musicaRepository.save(musicaNova);
				albumBanco.getMusicas().add(musicaNova);
			}
		}
		Capa capa = albumBanco.getCapa();
		capa.setData(file.getBytes());
		capa.setMimetype(file.getContentType());
		capaRepository.saveAndFlush(capa);
		return new AlbumDTO(albumRepository.saveAndFlush(albumBanco));
	}
	
	public void apagar(Long id) {
		albumRepository.deleteById(id);
	}
	
	public Capa getCapa(Long id) {
		Optional<Album> opAlbum = albumRepository.findById(id);
		if (opAlbum.isPresent()) {
			return opAlbum.get().getCapa();
		}
		return null;
	}


}
