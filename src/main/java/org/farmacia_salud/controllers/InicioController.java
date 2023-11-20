package org.farmacia_salud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("/inicio")
    public String mostrarInicio(Model model){
        return "inicio";
    }
}
