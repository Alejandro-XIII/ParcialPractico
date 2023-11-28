package com.udea.parcial2.service;

import com.udea.parcial2.dao.IProductoDAO;
import com.udea.parcial2.exception.ProductNotFoundException;
import com.udea.parcial2.model.Almacen;
import com.udea.parcial2.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProducto {
    @Autowired
    private IProductoDAO dao;

    public Producto save(Producto t) {
        return dao.save(t);
    }

    public String delete(long id) {
        dao.deleteById(id);
        return "Producto eliminado";
    }

    public Iterable<Producto> list() {
        return dao.findAll();
    }

    public Optional<Producto> listId(long id) {
        return dao.findById(id);
    }

    public Producto update(Producto t) {
        Producto existingProducto = dao.findById(t.getIdProducto()).orElse(null);
        existingProducto.setNombre(t.getNombre());
        existingProducto.setCantidad(t.getCantidad());
        return dao.save(existingProducto);
    }

    /*
    public List<Producto> findByAlmacen(Almacen Almacen) {
        List<Producto> drivers = dao.findByAlmacen(Almacen.getIdAlmacen());
        if (!drivers.isEmpty()) {
            return drivers;
        } else {
            throw new ProductNotFoundException("No hay conductores disponibles en ");
        }
    }

     */
}
