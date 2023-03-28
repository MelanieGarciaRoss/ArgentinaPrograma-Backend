
package com.portfolio.Melanie.controller;

import com.portfolio.Melanie.entity.Habilidad;
import com.portfolio.Melanie.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habilidad")
@CrossOrigin(origins="https://ap-frontend-ba0d5.web.app/") // ("http://localhost:4200")
public class HabilidadControlador {
   
    @Autowired
    private HabilidadService sHabilidad;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Habilidad>> lista(){
        List<Habilidad> list = sHabilidad.list();
        return new ResponseEntity<List<Habilidad>>(list, HttpStatus.OK);
    }
    
     //lista de relojes por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Habilidad> listaPer(@PathVariable Long id){
        return sHabilidad.findByPersonaId(id);    
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Habilidad> detail(@PathVariable("id") int id){
        Habilidad habilidad = sHabilidad.getOne(id);
        return new ResponseEntity<Habilidad>(habilidad, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void save(@RequestBody Habilidad habi) {
        sHabilidad.save(habi);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sHabilidad.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Habilidad habi) {
        sHabilidad.save(habi);
    }

}
