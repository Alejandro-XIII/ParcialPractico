package com.udea.parcial2.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@ApiModel(description = "Objeto de tipo Producto")
public class Producto implements Serializable {
    @ApiModelProperty(notes = "ID del producto")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto")
    private long idProducto;

    @ApiModelProperty(notes = "Nombre del almacen")
    @Column(name = "nombre", nullable = false, length = 80)
    private @NonNull String nombre;

    @ApiModelProperty(notes = "Nombre del almacen")
    @Column(name = "cantidad", nullable = false)
    private @NonNull int cantidad;

    @ApiModelProperty(notes = "Nombre del almacen")
    @ManyToOne
    @JoinColumn(name = "id_almacen")
    Almacen idAlmacen;
}
