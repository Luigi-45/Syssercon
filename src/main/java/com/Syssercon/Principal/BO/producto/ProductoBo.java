/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Syssercon.Principal.BO.producto;

import com.Syssercon.Principal.entities.Producto;
import com.Syssercon.Principal.repositories.IProductoRepository;
import com.Syssercon.Principal.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductoBo implements IProductoBOCRUD{
    
    @Autowired
    private IProductoRepository productoRepository;
    
    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(int producto_Id) {
        return productoRepository.findById(producto_Id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el producto con el id: "+producto_Id));
    }

    @Override
    public void delete(int insumo_Id) {
        productoRepository.deleteById(insumo_Id);
    }
    
    
}
