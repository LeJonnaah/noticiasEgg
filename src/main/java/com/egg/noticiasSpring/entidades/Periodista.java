package com.egg.noticiasSpring.entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Periodista extends Usuario {
    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    private List<Noticia> MisNoticias = new ArrayList<>();
    private Integer sueldoMensual;
}