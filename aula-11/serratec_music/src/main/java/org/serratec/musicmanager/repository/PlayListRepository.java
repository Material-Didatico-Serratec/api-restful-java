package org.serratec.musicmanager.repository;

import java.util.List;

import org.serratec.musicmanager.domain.PlayList;
import org.serratec.musicmanager.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Long>{
	
	public List<PlayList> findByUsuario(Usuario usuario);

}
