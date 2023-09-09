/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Syssercon.Principal.BO.producto;

import com.Syssercon.Principal.entities.Producto;
import java.util.List;

public interface IProductoBOCRUD {
    public Producto create(Producto producto);
    public List<Producto> findAll();
    public Producto findById(int producto_Id);
    public void delete(int producto_Id);
}
