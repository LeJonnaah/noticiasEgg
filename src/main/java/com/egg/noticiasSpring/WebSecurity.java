package com.egg.noticiasSpring;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
//import com.egg.noticiasSpring.servicios.UsuarioServicio;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurity implements WebSeguridad {

//    private final UsuarioServicio usuarioServicio;
//
//    public WebSecurity(UsuarioServicio usuarioServicio) {
//        this.usuarioServicio = usuarioServicio;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());
//    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll();
    }
}