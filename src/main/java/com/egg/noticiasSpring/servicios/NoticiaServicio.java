package com.egg.noticiasSpring.servicios;

import com.egg.noticiasSpring.entidades.Noticia;
import com.egg.noticiasSpring.repositorios.NoticiaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class NoticiaServicio {

    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    public List<Noticia> buscarNoticias() {
        return noticiaRepositorio.findAll();
    }

    public void crearNoticia(String titulo, String cuerpo) {
        Noticia noticia = new Noticia();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticiaRepositorio.save(noticia);
    }

    public void modificarNoticia(Long id, String titulo, String cuerpo) {
        Noticia noticia = noticiaRepositorio.findById(id).orElse(null);
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
        noticiaRepositorio.save(noticia);
    }

    public void eliminarNoticia(Long id) {
        noticiaRepositorio.deleteById(id);
    }

    public Noticia buscarNoticiaPorId(Long id) {
        return noticiaRepositorio.findById(id).orElse(null);
    }
}