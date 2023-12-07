package com.egg.noticiasSpring.entidades;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String cuerpo;

    @ManyToOne
    @JoinColumn(name = "periodista_id")
    private Periodista creador;
}
