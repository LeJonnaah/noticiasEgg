package com.egg.noticiasSpring.repositorios;

import com.egg.noticiasSpring.entidades.Noticia;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, Long> {

}


