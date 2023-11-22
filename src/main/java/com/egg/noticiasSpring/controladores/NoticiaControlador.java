package com.egg.noticiasSpring.controladores;

import com.egg.noticiasSpring.servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.egg.noticiasSpring.entidades.Noticia;
import java.util.List;

@Controller
public class NoticiaControlador {

    @Autowired
    private NoticiaServicio noticiaServicio;

    @GetMapping("/")
    public String mostrarInicio(Model model) {
        List<Noticia> noticias = noticiaServicio.buscarNoticias();
        model.addAttribute("noticias", noticias);
        return "inicio.html";
    }
}
