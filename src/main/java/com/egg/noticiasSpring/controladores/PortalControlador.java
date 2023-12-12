package com.egg.noticiasSpring.controladores;

import com.egg.noticiasSpring.servicios.NoticiaServicio;
//import com.egg.noticiasSpring.servicios.UsuarioServicio;

import com.egg.noticiasSpring.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class PortalControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "registro.html";
    }

    @PostMapping("/registrar")
    public String registro(@RequestParam String nombreUsuario, @RequestParam String password, @RequestParam String password2, ModelMap modelo) {
        try {
            usuarioServicio.registrar(nombreUsuario, password, password2);
            modelo.put("exito", "¡Te registraste con éxito!");
        } catch (Exception e) {
            modelo.put("error", e.getMessage());
            modelo.put("nombreUsuario", nombreUsuario);
            modelo.put("password", password);
            modelo.put("password2", password2);
            return "registro.html";
        }
        return "inicio.html";
    }
}
