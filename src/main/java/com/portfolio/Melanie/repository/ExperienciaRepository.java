
package com.portfolio.Melanie.repository;

import com.portfolio.Melanie.entity.Experiencia;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository <Experiencia, Integer>{
   List<Experiencia> findByPersonaId(Long personaId);
}
