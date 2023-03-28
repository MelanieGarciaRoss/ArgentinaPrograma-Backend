
package com.portfolio.Melanie.controller;

import com.portfolio.Melanie.entity.Persona;
import com.portfolio.Melanie.service.ImpPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins="https://ap-frontend-ba0d5.web.app/") // ("http://localhost:4200")
public class PersonaControlador {
    @Autowired ImpPersonaService  IPersonaService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = IPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> detail(@PathVariable("id") Long id){
        Persona perso = IPersonaService.getOne(id);
        return new ResponseEntity(perso, HttpStatus.OK);
    }       

    @PostMapping("/create")
    public void save(@RequestBody Persona persona){
        IPersonaService.save(persona);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        IPersonaService.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Persona persona){
        IPersonaService.edit(persona);
    }
   
       
}
