package com.example.APIClassRoom.modelos;

import jakarta.persistence.Entity;

import java.time.LocalDate;
@Entity
public class Estudiante {
    private Integer id;
    private Integer grado;
    private LocalDate fechaNacimiento;
    private String direccion;

    public Estudiante() {
    }

    public Estudiante(Integer id, Integer grado, LocalDate fechaNacimiento, String direccion) {
        this.id = id;
        this.grado = grado;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
