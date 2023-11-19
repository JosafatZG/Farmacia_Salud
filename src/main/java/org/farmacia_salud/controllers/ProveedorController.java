package org.farmacia_salud.controllers;

import org.farmacia_salud.models.services.interfaces.IProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProveedorController {
    private final IProveedorService service;

    public ProveedorController(IProveedorService service) {
        this.service = service;
    }

    @GetMapping("/proveedores")
    public String tablaProveedores(Model model){
        model.addAttribute("proveedores", service.findAll());
        return "proveedores";
    }
}
