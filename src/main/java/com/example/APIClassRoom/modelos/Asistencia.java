package com.example.APIClassRoom.modelos;

import com.example.APIClassRoom.ayudas.EstadoAsistencia;
import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class Asistencia {
    private Integer id;
    private LocalDate fecha;
    private EstadoAsistencia estado;

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
