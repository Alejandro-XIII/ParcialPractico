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
@ApiModel(description = "Almacen al que se le maneja el inventario")
public class Almacen implements Serializable {
    @ApiModelProperty(notes = "ID del almacen")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_almacen")
    private long idAlmacen;

    @ApiModelProperty(notes = "Nombre del almacen")
    @Column(name = "nombre", nullable = false, length = 80)
    private @NonNull String nombre;
}

