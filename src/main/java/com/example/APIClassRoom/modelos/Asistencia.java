package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.EstadoAsistencia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_asistencia")
    private Integer id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private EstadoAsistencia estado;

    //relacion con la tabla estudiante
    @ManyToOne
    @JoinColumn(name="fk_estudiante",referencedColumnName = "id_estudiante")
    @JsonBackReference
    private Estudiante estudiante;

    public Asistencia() {
    }

    public Asistencia(Integer id, LocalDate fecha, EstadoAsistencia estado) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsistencia estado) {
        this.estado = estado;
    }
}
