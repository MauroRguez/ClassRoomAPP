package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_calificacion")
    private Integer id;

    @Column(nullable = false)
    private float nota;

    @Column(name="fecha_evaluacion",nullable = false)
    private LocalDate fechaEvaluacion;

    //relacion con la tabla estudiante
    @ManyToOne
    @JoinColumn(name="fk_estudiante",referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    //relacion con la tabla materia
    @ManyToOne
    @JoinColumn(name="fk_materia",referencedColumnName = "id_materia")
    @JsonBackReference
    private Materia materia;

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
