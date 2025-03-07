package com.example.APIClassRoom.modelos;

import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class Calificacion {
    private Integer id;
    private float nota;
    private LocalDate fechaEvaluacion;

    public Calificacion() {
    }

    public Calificacion(Integer id, float nota, LocalDate fechaEvaluacion) {
        this.id = id;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
