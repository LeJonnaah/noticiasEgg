package com.egg.noticiasSpring.servicios;

import com.egg.noticiasSpring.entidades.Usuario;
import com.egg.noticiasSpring.repositorios.UsuarioRepositorio;
import com.egg.noticiasSpring.enumeraciones.Rol;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public void registrar(String nombreUsuario,String password, String password2) throws Exception {
        if (!password.equals(password2)) {
            throw new Exception("Las contraseñas no coinciden");
        }
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setPassword(password);
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);
    }

    @Transactional
    public void registrar() throws Exception {
        String email = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();
        Usuario usuario = new Usuario();
        usuario.setPassword(password);
        usuario.setRol(Rol.USER);
        usuario.setAlta(new java.sql.Date(System.currentTimeMillis()));
        usuarioRepositorio.save(usuario);
        System.out.println("Generated user: " + email + " with password: " + password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepositorio.buscarPorNombreUsuario(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(user.getNombreUsuario(), user.getPassword(), new ArrayList<>());
    }

}
