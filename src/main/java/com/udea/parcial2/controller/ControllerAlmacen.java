package com.udea.parcial2.controller;

import com.udea.parcial2.exception.ModelNotFoundException;
import com.udea.parcial2.model.Almacen;
import com.udea.parcial2.service.ServicioAlmacen;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almacen")
@CrossOrigin("*")
@Api(value = "Sistema de manejo de inventario", description = "Operaciones en almacen")
public class ControllerAlmacen {
    @Autowired
    private ServicioAlmacen servicioAlmacen;

    @ApiOperation(value = "Agregar almacen")
    @PostMapping("/save")
    public long save(
            @ApiParam(value = "Objeto de tipo Almacen que se almacenará en la BD", required = true)
            @RequestBody Almacen almacen) throws ModelNotFoundException {
        servicioAlmacen.save(almacen);
        return almacen.getIdAlmacen();
    }

    @ApiOperation(value = "Mostrar todos los almacenes", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the source"),
            @ApiResponse(code = 403, message = "The source that you are trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Almacen not found")
    })
    @GetMapping("/listAll")
    public Iterable<Almacen> listAllDrivers() {
        return servicioAlmacen.list();
    }

    @ApiOperation(value = "Mostrar un almacen por su ID")
    @GetMapping("/list/{id}")
    public Almacen listDriverByID(@ApiParam(value = "Ingrese el ID del conductor a buscar", required = true)
                                 @PathVariable("id") int id) {
        Optional<Almacen> almacen = servicioAlmacen.listId(id);
        if (almacen.isPresent()) {
            return almacen.get();
        }
        throw new ModelNotFoundException("ID de almacen invalida");
    }

    @ApiOperation(value = "Actualizar datos de un almacen")
    @PutMapping
    public Almacen updateService(@RequestBody Almacen almacen) {
        return servicioAlmacen.update(almacen);
    }

    @ApiOperation(value = "Eliminar almacen")
    @DeleteMapping("/{id}")
    public String deleteAlmacen(@PathVariable long id) {
        return servicioAlmacen.delete(id);
    }
}
