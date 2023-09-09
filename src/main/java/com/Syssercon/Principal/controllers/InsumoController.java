/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Syssercon.Principal.controllers;

import com.Syssercon.Principal.entities.Insumo;
import com.Syssercon.Principal.BO.insumo.IInsumoBOCRUD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/insumo")
@CrossOrigin(origins = "*")
public class InsumoController {
    
    @Autowired
    private IInsumoBOCRUD insumoBO;
    
    @GetMapping
    public List<Insumo> findAll(){
        return (ArrayList<Insumo>) insumoBO.findAll();
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Insumo> findById(@PathVariable int id){
        Insumo insumo = insumoBO.findById(id);
        return ResponseEntity.ok(insumo);
    }
    
    @PostMapping("/save")
    public Insumo save(@RequestBody Insumo insumo){
        return insumoBO.create(insumo);
    }
    
    /*@PutMapping("/update/{id}")
    public ResponseEntity<Insumo> update (@PathVariable int id, @RequestBody Insumo insumorequest){
        Insumo insumo = insumoBO.findById(id);
        insumo.setDescripcion(insumorequest.getDescripcion());
        insumo.setMedida(insumorequest.getMedida());
        insumo.setNombre(insumorequest.getNombre());
        insumo.setTipo(insumorequest.getTipo());
        insumo.setUnidad_medida(insumorequest.getUnidad_medida());
        
        Insumo IActualizado=insumoBO.save(insumo);
        
        return ResponseEntity.ok(IActualizado);
    }*/
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> delete (@PathVariable int id){
        insumoBO.delete(id);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
