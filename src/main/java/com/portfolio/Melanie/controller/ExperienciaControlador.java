
package com.portfolio.Melanie.controller;

import com.portfolio.Melanie.entity.Experiencia;
import com.portfolio.Melanie.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins="https://ap-frontend-ba0d5.web.app/") // ("http://localhost:4200")
public class ExperienciaControlador {
   
     @Autowired
    ExperienciaService sExperiencia;
    
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Experiencia>> lista(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      //lista de experiencias por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Experiencia> listaPer(@PathVariable Long id){
        return sExperiencia.findByPersonaId(id);    
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> detail(@PathVariable("id") int id){
        Experiencia expe = sExperiencia.getOne(id);
        return new ResponseEntity(expe, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void save(@RequestBody Experiencia expe) {      
        sExperiencia.save(expe);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sExperiencia.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Experiencia expe) {      
        sExperiencia.save(expe);
    }
}
