package com.egg.noticiasSpring.entidades;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Administrador extends Usuario {

        public Administrador() {
        }

        public Administrador(String email, String password, String nombre, String apellido) {
            super(email, password, nombre, apellido);
        }

        @Override
        public String toString() {
            return "Administrador{" + super.toString() + '}';
        }
}
