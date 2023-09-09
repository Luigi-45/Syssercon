/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Syssercon.Principal.BO.insumo;


import com.Syssercon.Principal.entities.Insumo;
import com.Syssercon.Principal.repositories.IInsumoRepository;
import com.Syssercon.Principal.util.exceptions.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsumoBO implements IInsumoBOCRUD{

    @Autowired
    private IInsumoRepository insumoRepository;
    
    @Override
    public Insumo create(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    @Override
    public List<Insumo> findAll() {
        return insumoRepository.findAll();
    }

    @Override
    public Insumo findById(int insumo_Id) {
        return insumoRepository.findById(insumo_Id)
                .orElseThrow(() -> new ResourceNotFoundException("No existe el insumo con el id: "+insumo_Id));
    }

    @Override
    public void delete(int insumo_Id) {
        insumoRepository.deleteById(insumo_Id);
    }

    
    
}
