package com.example.APIClassRoom.servicios;


import com.example.APIClassRoom.modelos.Estudiante;
import com.example.APIClassRoom.repositorio.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    IEstudianteRepositorio Repositorio;

    //GUARDAR
    public Estudiante guardarEstudiante(Estudiante datosEstudiante) throws Exception {
        try {
            return this.Repositorio.save(datosEstudiante);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //MODIFICAR
    public Estudiante modificarEstudiante(Integer id, Estudiante datosEstudiante) throws Exception {
       try{
           Optional<Estudiante> estudianteBuscado=this.Repositorio.findById(id);

           if(estudianteBuscado.isPresent()){
              estudianteBuscado.get().setGrado(datosEstudiante.getGrado());
              estudianteBuscado.get().setDireccion(datosEstudiante.getDireccion());
              estudianteBuscado.get().setFechaNacimiento(datosEstudiante.getFechaNacimiento());
              return this.Repositorio.save(estudianteBuscado.get());
           }else{
               throw new Exception("No hay estudiante para modificar");
           }
       } catch (Exception error){
           throw new Exception(error.getMessage());

       }


    }


}
