package com.udea.parcial2.dao;

import com.udea.parcial2.model.Almacen;
import com.udea.parcial2.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoDAO extends CrudRepository<Producto, Long> {
    /*
    @Query("FROM Producto p WHERE p.id_almacen=:id_almacen")
    public List<Producto> findByAlmacen(@Param("almacen") long idAlmacen);
     */
}
