package com.egg.noticiasSpring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControlador {


    @GetMapping("/dashboard")
    public String panelAdministrativo(){
        return "panelAdmin.html";
    }

}