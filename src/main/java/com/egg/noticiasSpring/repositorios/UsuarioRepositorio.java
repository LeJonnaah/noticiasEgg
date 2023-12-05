package com.egg.noticiasSpring.repositorios;

import com.egg.noticiasSpring.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

    public Usuario buscarPorNombre(String email);
}
