package org.farmacia_salud.controllers;

import org.farmacia_salud.models.services.interfaces.IMovimientoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovimientoController {
    private final IMovimientoService service;

    public MovimientoController(IMovimientoService service) {
        this.service = service;
    }

    @GetMapping("/movimientos")
    public String tablaMovimientos(Model model) {
        model.addAttribute("movimientos", service.findAll());
        return "movimientos";
    }
}
