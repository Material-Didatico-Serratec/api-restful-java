package org.serratec.musicmanager.repository;

import org.serratec.musicmanager.domain.Capa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CapaRepository extends JpaRepository<Capa, Long>{

}
