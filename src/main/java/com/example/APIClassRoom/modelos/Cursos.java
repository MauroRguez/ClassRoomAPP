package com.example.APIClassRoom.modelos;

import jakarta.persistence.Entity;

@Entity
public class Cursos {
    private Integer id;
    private String nombre;

    public Cursos() {
    }

    public Cursos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
