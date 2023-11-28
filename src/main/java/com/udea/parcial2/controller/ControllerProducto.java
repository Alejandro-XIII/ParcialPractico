package com.udea.parcial2.controller;

import com.udea.parcial2.exception.ModelNotFoundException;
import com.udea.parcial2.model.Almacen;
import com.udea.parcial2.model.Producto;
import com.udea.parcial2.service.ServiceProducto;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CrossOrigin("*")
@Api(value = "Manejo de los productos", description = "Operaciones en productos")
public class ControllerProducto {
    @Autowired
    private ServiceProducto servicioProducto;

    @ApiOperation(value = "Agregar producto nuevo a un almacén")
    @PostMapping("/save")
    public long save(
            @ApiParam(value = "Objeto de tipo Producto que se almacenará en la BD", required = true)
            @RequestBody Producto producto) throws ModelNotFoundException {
        servicioProducto.save(producto);
        return producto.getIdProducto();
    }

    @ApiOperation(value = "Mostrar todos los productos", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the source"),
            @ApiResponse(code = 403, message = "The source that you are trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Driver not found")
    })
    @GetMapping("/listAll")
    public Iterable<Producto> listAllProducts() {
        return servicioProducto.list();
    }

    @ApiOperation(value = "Mostrar un almacén por su ID")
    @GetMapping("/list/{id}")
    public Producto listProductoByID(@ApiParam(value = "Ingrese el ID del producto a buscar", required = true)
                                 @PathVariable("id") int id) {
        Optional<Producto> producto = servicioProducto.listId(id);
        if (producto.isPresent()) {
            return producto.get();
        }
        throw new ModelNotFoundException("ID de producto invalida");
    }

    @ApiOperation(value = "Actualizar cantidad de productos de un almacén")
    @PutMapping
    public Producto updateService(@RequestBody Producto producto) {
        return servicioProducto.update(producto);
    }

    @ApiOperation(value = "Eliminar producto de un almacén")
    @DeleteMapping("/{id}")
    public String deleteProducto(@PathVariable long id) {
        return servicioProducto.delete(id);
    }

    /*
    @ApiOperation(value = "Productos en un almacen")
    @GetMapping("/byAlmacen/{idAlmacen}")
    public ResponseEntity<List<Producto>> findByAlmacen(@PathVariable("almacen") Almacen Almacen) {
        List<Producto> productos = servicioProducto.findByAlmacen(Almacen);
        return new ResponseEntity<List<Producto>>(productos, HttpStatus.ACCEPTED);
    }
     */
}
