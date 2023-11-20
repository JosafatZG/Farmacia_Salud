package org.farmacia_salud.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venta_id")
    private Long ventaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @NotNull
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull
    @Column(name = "fecha")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
}
