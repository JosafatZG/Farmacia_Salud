package org.farmacia_salud.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Currency;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long productoId;

    @NotBlank
    @Column(name = "nombre")
    private String nombre;

    @NotBlank
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "precio_de_compra")
    private Double precioDeCompra;

    @NotNull
    @Column(name = "precio_de_venta")
    private Double precioDeVenta;

    @NotNull
    @Column(name = "stock")
    private Integer stock;

    public Producto() {
    }
}
