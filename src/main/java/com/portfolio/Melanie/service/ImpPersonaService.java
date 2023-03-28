/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Melanie.service;

import com.portfolio.Melanie.entity.Persona;
import com.portfolio.Melanie.repository.PersonaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpPersonaService  {
    @Autowired PersonaRepository rPersona;
    
    
    
   public List<Persona> list(){
        return rPersona.findAll();
    }
    
    public Persona getOne(Long id){
        Persona perso = rPersona.findById(id).orElse(null);
        return perso;
    }    
   
    
    public void save(Persona pers){
        rPersona.save(pers);
    }      
    
   
     public void delete(Long id){
        rPersona.deleteById(id);
    }    
     
     public void edit(Persona pers){
        rPersona.save(pers);
    }  
       
}