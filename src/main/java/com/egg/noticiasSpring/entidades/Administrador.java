package com.egg.noticiasSpring.entidades;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Administrador extends Usuario {

        public Administrador() {
        }

        public Administrador(String password, String nombre, String apellido) {
            super( password, nombre, apellido);
        }

        @Override
        public String toString() {
            return "Administrador{" + super.toString() + '}';
        }
}
