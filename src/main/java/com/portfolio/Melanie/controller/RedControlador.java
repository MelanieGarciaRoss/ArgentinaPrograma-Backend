package com.portfolio.Melanie.controller;

import com.portfolio.Melanie.entity.Red;
import com.portfolio.Melanie.service.RedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/red")
@CrossOrigin(origins="https://ap-frontend-ba0d5.web.app/") // ("http://localhost:4200")
public class RedControlador {
    @Autowired
    RedService sRed;
    
    
    @GetMapping ("/lista")
    public ResponseEntity<List<Red>> list(){
        List<Red> list = sRed.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
      //lista de relojes por id de persona
    @GetMapping ("/persona/{id}/lista")
    public List <Red> findByPersonaId(@PathVariable Long id){
        return sRed.findByPersonaId(id);    
        }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Red> getById(@PathVariable("id") int id){
        Red red = sRed.getOne(id);
        return new ResponseEntity(red, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public void create(@RequestBody Red red) {      
        sRed.save(red);
    }
    
      @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable ("id") int id){
        sRed.delete(id);
    }
    
    @PutMapping("/update")
    public void edit(@RequestBody Red red) {      
        sRed.save(red);
    }
    
}
