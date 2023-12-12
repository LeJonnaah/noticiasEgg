package com.egg.noticiasSpring;

import com.egg.noticiasSpring.servicios.UsuarioServicio;
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

    private final UsuarioServicio usuarioServicio;

    public WebSecurity(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .requestMatchers("/admin/*").hasRole("ADMIN")
                .requestMatchers("/css/*", "/js/*", "/img/*", "/**")
                .permitAll()
                .and().formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/logincheck")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/inicio")
                .permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and().csrf()
                .disable();
    }
}