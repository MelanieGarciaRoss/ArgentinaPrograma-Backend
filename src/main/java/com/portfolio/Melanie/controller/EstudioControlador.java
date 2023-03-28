
package com.portfolio.Melanie.controller;

import com.portfolio.Melanie.entity.Estudio;
import com.portfolio.Melanie.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
@CrossOrigin(origins="https://ap-frontend-ba0d5.web.app/") // ("http://localhost:4200")
public class EstudioControlador {
    
    @Autowired
    private EstudioService sEstudio;
    
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      //lista de relojes por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Estudio> listaPer(@PathVariable Long id){
        return sEstudio.findByPersonaId(id);    
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> detail(@PathVariable("id") int id){
        Estudio estu = sEstudio.getOne(id);
        return new ResponseEntity(estu, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void save(@RequestBody Estudio estu) {      
        sEstudio.save(estu);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sEstudio.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Estudio estu) {      
        sEstudio.save(estu);
    }
    
}
