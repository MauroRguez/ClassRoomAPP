package com.example.APIClassRoom.modelos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_docente")
    private Integer id;

    @Column(nullable = false, length = 100)
    private  String especialidad;

    //realcion con la tabla curso
    @OneToMany(mappedBy = "docente")
    @JsonManagedReference(value="docente-curso")
    private List<Curso> cursos;

    //relacion uno a uno con usuario
    @OneToOne
    @JoinColumn(name="fk_usuario",referencedColumnName = "id_usuario")
    @JsonManagedReference(value="docente-usuario")
    private Usuario usuario;


    public Docente() {
    }

    public Docente(Integer id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
