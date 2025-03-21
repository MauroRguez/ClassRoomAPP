package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_materia")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    //relacion con la tabla calificacion
    @OneToMany(mappedBy = "materia")
    @JsonManagedReference
    private List<Calificacion> calificaciones;

    //relacion con la tabla curso
    @ManyToOne
    @JoinColumn(name="fk_curso",referencedColumnName ="id_curso" )
    @JsonBackReference
    private Curso curso;

    public Materia() {
    }

    public Materia(Integer id, String nombre) {
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
