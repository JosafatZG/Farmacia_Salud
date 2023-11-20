package org.farmacia_salud.models.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class VentaDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long compraId;
    private Long productoId;
    private Integer cantidad;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;
}
