package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Curso;
import com.example.APIClassRoom.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Curso modificarCurso(Integer id, Curso datosCurso) throws Exception{

        try{
            Optional<Curso> cursoBuscado=this.Repositorio.findById(id);

            if(cursoBuscado.isPresent()){
                cursoBuscado.get().setNombre(datosCurso.getNombre());

                return this.Repositorio.save(cursoBuscado.get());
            }else{
                throw new Exception("No hay curso para modificar");
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }





    //BUSCAR ID

    // BUSCAR TODOS

    //ELIMINAR



}
