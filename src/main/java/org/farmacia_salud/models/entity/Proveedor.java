package org.farmacia_salud.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proveedor_id")
    private Long proveedorId;

    @NotBlank
    @Column(name = "proveedor")
    private String proveedor;

    @NotBlank
    @Column(name = "direccion")
    private String direccion;

    @NotBlank
    @Column(name = "telefono")
    private String telefono;

    @NotBlank
    @Column(name = "celular")
    private String celular;

    @Email
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotBlank
    @Column(name = "persona_contacto")
    private String personaContacto;

    public Proveedor() {
    }
}
