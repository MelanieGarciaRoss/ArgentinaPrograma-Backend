
package com.portfolio.Melanie.repository;

import com.portfolio.Melanie.entity.Estudio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Integer> {
    
    List<Estudio> findByPersonaId(Long personaId);
}
