package org.serratec.musicmanager.repository;

import org.serratec.musicmanager.domain.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long>{

}
