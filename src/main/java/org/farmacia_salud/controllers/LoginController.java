package org.farmacia_salud.controllers;

import org.farmacia_salud.models.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String iniciarSesion(@ModelAttribute("user") User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("pass123")) {
            return "redirect:/inicio";
        }
        return "login";
    }
}
