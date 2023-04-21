package org.serratec.musicmanager.repository;

import org.serratec.musicmanager.domain.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica,Long>{

}
