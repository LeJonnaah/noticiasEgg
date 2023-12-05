package com.egg.noticiasSpring.entidades;

import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;

    private String username;
    private String password;
    private String email;

    @Enumerated (EnumType.STRING)
    private Rol rol;
}
