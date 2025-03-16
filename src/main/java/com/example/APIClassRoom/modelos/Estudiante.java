package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_estudiante")
    private Integer id;

    @Column(nullable = false)
    private Integer grado;

    @Column (name="fecha_nacimiento",nullable = false)
    private LocalDate fechaNacimiento;

    @Column(nullable = false, length = 255)
    private String direccion;

    @OneToOne
    @JoinColumn(name="fk_usuario", referencedColumnName = "id_usuario")
    @JsonManagedReference
    private Usuario usuario;

    //relacion con la tabla inscripcion
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Inscripcion> inscripciones;

    //realacion con tabla calificacion
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    //relacion con asistencia
    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference
    private List<Asistencia> asistencias;

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
