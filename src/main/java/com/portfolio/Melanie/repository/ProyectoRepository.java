
package com.portfolio.Melanie.repository;

import com.portfolio.Melanie.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Integer>{
    
    
}
