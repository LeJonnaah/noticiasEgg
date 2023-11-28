package com.egg.noticiasSpring.controladores;

import com.egg.noticiasSpring.servicios.NoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.egg.noticiasSpring.entidades.Noticia;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/ver/{id}")
    public String verNoticia(@PathVariable Long id, Model model) {
        Noticia noticia = noticiaServicio.buscarNoticiaPorId(id);
        if (noticia != null) {
            model.addAttribute("noticia", noticia);
            return "ver";
        } else {
            // Manejar el caso en que la noticia no se encuentre
            return "redirect:/noticias/listar";
        }
    }

    @GetMapping("/crear")
    public String mostrarCrear(Model model) {
        List<Noticia> noticias = noticiaServicio.buscarNoticias();
        model.addAttribute("noticias", noticias);
        model.addAttribute("noticia", new Noticia());
        return "panelAdmin.html";
    }

    @PostMapping("/nueva")
    public String agregarNoticia(@ModelAttribute Noticia noticia) {
        noticia.setId(null);
        noticiaServicio.crearNoticia(noticia);
        return "redirect:/crear";
    }

    @GetMapping("/editarNoticia")
    public String mostrarEditar(Model model, Long id) {
        Noticia noticia = noticiaServicio.buscarNoticiaPorId(id);
        model.addAttribute("noticia", noticia);
        return "panelAdmin.html";
    }

    @PostMapping("/modificar")
    public String modificarNoticia(@ModelAttribute Noticia noticia) {
        noticiaServicio.modificarNoticia(noticia.getId(), noticia.getTitulo(), noticia.getCuerpo());
        return "redirect:/";
    }

}
