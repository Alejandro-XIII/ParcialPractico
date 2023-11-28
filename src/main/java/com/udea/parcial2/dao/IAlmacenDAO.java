package com.udea.parcial2.dao;

import com.udea.parcial2.model.Almacen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlmacenDAO extends CrudRepository<Almacen, Long> {
}
