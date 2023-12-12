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
    public void registrar(String email, String password, String password2) throws Exception {
        if (!password.equals(password2)) {
            throw new Exception("Las contraseñas no coinciden");
        }
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);
    }

    @Transactional
    public void registrar() throws Exception {
        String email = UUID.randomUUID().toString();
        String password = UUID.randomUUID().toString();
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);
        System.out.println("Generated user: " + email + " with password: " + password);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.buscarPorMail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }
    }

}
