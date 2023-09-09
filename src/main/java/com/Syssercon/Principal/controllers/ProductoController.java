/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Syssercon.Principal.controllers;

import com.Syssercon.Principal.entities.Producto;
import com.Syssercon.Principal.BO.producto.IProductoBOCRUD;
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
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoController {
    
    @Autowired
    private IProductoBOCRUD productoBO;
    
    @GetMapping
    public List<Producto> findAll(){
        return (ArrayList<Producto>) productoBO.findAll();
    }
    
    @GetMapping("/findById/{id}")
    public ResponseEntity<Producto> findById(@PathVariable int id){
        Producto producto = productoBO.findById(id);
        return ResponseEntity.ok(producto);
    }
    
    @PostMapping("/save")
    public Producto save(@RequestBody Producto producto){
        return productoBO.create(producto);
    }
    
    /*@PutMapping("/update/{id}")
    public ResponseEntity<Producto> update (@PathVariable int id, @RequestBody Producto productorequest){
        Producto producto = productoBO.findById(id);
        producto.setDescripcion(productorequest.getDescripcion());
        producto.setMedida(productorequest.getMedida());
        producto.setNombre(productorequest.getNombre());
        producto.setTipo(productorequest.getTipo());
        producto.setUnidad_medida(productorequest.getUnidad_medida());
        
        Producto PActualizado=productoBO.save(producto);
        
        return ResponseEntity.ok(PActualizado);
    }*/
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> delete (@PathVariable int id){
        productoBO.delete(id);
        
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
    
}
