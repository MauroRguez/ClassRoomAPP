package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="id_inscripcion")
    private Integer id;

    @Column(name="fecha_inscripcion")
    private LocalDate fechaInscripcion;

    //dudas mirar el pdf esta resaltado

    //relacionando con la tabla estudiante
    @ManyToOne
    @JoinColumn(name="fk_estudiante",referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    //relacionando con la tabla curso
    @ManyToOne
    @JoinColumn(name="fk_curso",referencedColumnName = "id_curso")
    @JsonBackReference
    private Curso curso;

    

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
