package org.farmacia_salud.controllers;

import org.farmacia_salud.models.services.interfaces.IProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductoController {

    private final IProductoService service;

    public ProductoController(IProductoService service) {
        this.service = service;
    }

    @GetMapping("/productos")
    public String tablaProductos(Model model){
        model.addAttribute("productos", service.findAll());
        return "productos";
    }
}
