package com.udea.parcial2.service;

import com.udea.parcial2.dao.IAlmacenDAO;
import com.udea.parcial2.model.Almacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioAlmacen {
    @Autowired
    private IAlmacenDAO dao;

    public Almacen save(Almacen t) {
        return dao.save(t);
    }

    public String delete(long id) {
        dao.deleteById(id);
        return "Almacen eliminado";
    }

    public Iterable<Almacen> list() {
        return dao.findAll();
    }

    public Optional<Almacen> listId(long id) {
        return dao.findById(id);
    }

    public Almacen update(Almacen t) {
        Almacen existingAlmacen = dao.findById(t.getIdAlmacen()).orElse(null);
        existingAlmacen.setNombre(t.getNombre());
        return dao.save(existingAlmacen);
    }
}

