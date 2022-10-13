package org.serratec.musicmanager.repository;

import org.serratec.musicmanager.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>{

}
