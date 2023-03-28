
package com.portfolio.Melanie.repository;

import com.portfolio.Melanie.entity.Habilidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad, Integer> {
    List<Habilidad> findByPersonaId(Long personaId);
}
