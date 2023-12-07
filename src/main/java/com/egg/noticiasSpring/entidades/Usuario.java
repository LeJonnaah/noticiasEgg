package com.egg.noticiasSpring.entidades;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String nombreUsuario;
    private String email;
    private String password;
    private boolean activo;

    @Temporal(TemporalType.DATE)
    protected Date alta;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Usuario(String email, String password, String nombre, String apellido) {
        this.email = email;
        this.password = password;
        this.nombreUsuario = nombre + " " + apellido;
        this.activo = true;
    }

    public Usuario() {

    }
}