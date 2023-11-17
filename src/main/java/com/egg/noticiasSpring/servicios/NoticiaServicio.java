package com.egg.noticiasSpring.servicios;

import com.egg.noticiasSpring.entidades.Noticia;
import com.egg.noticiasSpring.repositorios.NoticiaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class NoticiaServicio {

//    @Autowired
    private NoticiaRepositorio noticiaRepositorio;

    public List<Noticia> listarNoticias() {

        List<Noticia> noticias = new ArrayList();
        noticias = noticiaRepositorio.findAll();
        System.out.println("Noticias: " + noticias);

        return noticias;
    }


    public Noticia buscarPorId(Long id) {
        return noticiaRepositorio.findById(id).orElse(null);
    }

    public void guardar(Noticia noticia) {
        noticiaRepositorio.save(noticia);
    }

    public void eliminar(Long id) {
        noticiaRepositorio.deleteById(id);
    }

}
