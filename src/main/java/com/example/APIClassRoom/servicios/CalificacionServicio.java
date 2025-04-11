package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Calificacion;
import com.example.APIClassRoom.repositorio.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalificacionServicio {

    @Autowired
    ICalificacionRepositorio repositorio;


    //GUARDAR
    public Calificacion guardarCalificacion(Calificacion datosCalificacion) throws Exception {
        try {
            return this.repositorio.save(datosCalificacion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    //MODIFICAR

    public Calificacion modificarCalificacion(Integer id, Calificacion datosCalificacion) throws Exception{

        try{
            Optional <Calificacion> calificacionBuscado=this.repositorio.findById(id);

            if(calificacionBuscado.isPresent()){
                calificacionBuscado.get().setNota(datosCalificacion.getNota());
                calificacionBuscado.get().setFechaEvaluacion(datosCalificacion.getFechaEvaluacion());
                return this.repositorio.save(calificacionBuscado.get());
            }else{
                throw new Exception("No hay calificaciones para mostrar");
            }

        }catch  (Exception error){
            throw new Exception(error.getMessage());
        }



    }


}
