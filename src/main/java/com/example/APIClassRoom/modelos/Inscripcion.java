package com.example.APIClassRoom.modelos;

import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class Inscripcion {
    private Integer id;
    private LocalDate fechaInscripcion;

    public Inscripcion() {
    }

    public Inscripcion(Integer id, LocalDate fechaInscripcion) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
