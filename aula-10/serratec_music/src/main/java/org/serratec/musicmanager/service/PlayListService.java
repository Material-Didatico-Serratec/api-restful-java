package org.serratec.musicmanager.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.musicmanager.domain.Musica;
import org.serratec.musicmanager.domain.PlayList;
import org.serratec.musicmanager.dto.PlayListDTO;
import org.serratec.musicmanager.repository.MusicaRepository;
import org.serratec.musicmanager.repository.PlayListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayListService {
	@Autowired
	private PlayListRepository playListRepository;
	
	@Autowired
	private MusicaRepository musicaRepository;
	
	@Transactional(readOnly = true)
	public List<PlayListDTO> findAll(){
		List<PlayList> albuns = playListRepository.findAll();
		List<PlayListDTO> dtos = new ArrayList<>();
		for(PlayList playList:albuns) {
			dtos.add(new PlayListDTO(playList));
		}
		return dtos;
	}
	
	public PlayListDTO findById(Long id) {
		Optional<PlayList> optPlayList = playListRepository.findById(id);
		if (optPlayList.isPresent()) {
			return new PlayListDTO(optPlayList.get());
		}
		return null;
	}
	
	@Transactional
	public PlayListDTO inserir(PlayListDTO playListDto) throws IOException {
		PlayList playList = new PlayList();
		playList.setNome(playListDto.getNome());
		playList.setMusicas(new ArrayList<>());
		for(Musica musica: playListDto.getMusicas()) {
			Optional<Musica> opMusica = musicaRepository.findById(musica.getId());
			if (opMusica.isPresent()) {
				playList.getMusicas().add(opMusica.get());
			}
		}
		playList = playListRepository.saveAndFlush(playList);
		return new PlayListDTO(playList);
	}
	
	@Transactional
	public PlayListDTO atualizar(Long id, PlayListDTO playListDto) throws IOException {
		Optional<PlayList> opPlayList = playListRepository.findById(id);
		if (opPlayList.isEmpty()) {
			return null;
		}
		PlayList playListBanco = opPlayList.get();
		playListBanco.setNome(playListDto.getNome());
		playListBanco.setMusicas(new ArrayList<>());
		for(Musica musica: playListDto.getMusicas()) {
			Optional<Musica> opMusica = musicaRepository.findById(musica.getId());
			if (opMusica.isPresent()) {
				playListBanco.getMusicas().add(opMusica.get());
			}
		}
		return new PlayListDTO(playListRepository.saveAndFlush(playListBanco));
	}
	
	public void apagar(Long id) {
		playListRepository.deleteById(id);
	}
	


}
