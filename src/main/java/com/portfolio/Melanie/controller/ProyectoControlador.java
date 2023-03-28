
package com.portfolio.Melanie.controller;

import com.portfolio.Melanie.entity.Proyecto;
import com.portfolio.Melanie.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins="https://ap-frontend-ba0d5.web.app/") // ("http://localhost:4200")
public class ProyectoControlador {
    
    @Autowired
    ProyectoService sProyecto;
    
    @GetMapping ("/proyecto/lista")
    public ResponseEntity<List<Proyecto>> lista(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
     
    @GetMapping("/proyecto/detail/{id}")
    public ResponseEntity<Proyecto> detail(@PathVariable("id") int id){
        Proyecto proye = sProyecto.getOne(id);
        return new ResponseEntity(proye, HttpStatus.OK);
    }
    
    @PostMapping("/proyecto/create")
    public void create(@RequestBody Proyecto proye) {
        sProyecto.save(proye);
    }
    
    
    @DeleteMapping("/proyecto/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sProyecto.delete(id);
    }
    
    @PutMapping("/proyecto/update")
    public void edit(@RequestBody Proyecto proye) {
        sProyecto.edit(proye);
    }
    
}
