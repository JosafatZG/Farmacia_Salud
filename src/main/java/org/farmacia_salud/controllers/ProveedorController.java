package org.farmacia_salud.controllers;

import org.farmacia_salud.models.entity.Proveedor;
import org.farmacia_salud.models.services.interfaces.IProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {
    private final IProveedorService service;

    public ProveedorController(IProveedorService service) {
        this.service = service;
    }

    @GetMapping("/proveedores")
    public String tablaProveedores(Model model) {
        model.addAttribute("proveedorAdd", new Proveedor());
        model.addAttribute("proveedores", service.findAll());
        return "proveedores";
    }

    @PostMapping("/proveedores")
    public String agregarProveedor(@ModelAttribute("proveedorAdd") Proveedor proveedor) {
        service.save(proveedor);
        return "redirect:/proveedores";
    }
}
