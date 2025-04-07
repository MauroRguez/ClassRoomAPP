package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Curso;
import com.example.APIClassRoom.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicio {

    @Autowired
    ICursoRepositorio Repositorio;

    //GUARDAR
    public Curso guardarCurso(Curso datosCurso) throws Exception {
        try {
            return  this.Repositorio.save(datosCurso);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR

    //BUSCAR ID

    // BUSCAR TODOS

    //ELIMINAR



}
