package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Calificacion;
import com.example.APIClassRoom.repositorio.ICalificacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }

        }catch  (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    //BUSCAR ID
    public Calificacion buscarCalificacionPorId(Integer id) throws Exception{
        try {
            Optional<Calificacion> calificacionBuscado = this.repositorio.findById(id);
            if(calificacionBuscado.isPresent()) {
                return calificacionBuscado.get();
            }else {
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    // BUSCAR TODOS
    public List<Calificacion> buscarTodasCalificaciones() throws Exception{
        try {
            return this.repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR

    public boolean eliminarCalificacion(Integer id) throws Exception{
        try {
            Optional<Calificacion> calificacionBuscado = this.repositorio.findById(id);
            if(calificacionBuscado.isPresent()){
                this.repositorio.delete(calificacionBuscado.get());
                return true;
            }else{
                throw new Exception(MensajesAPI.CALIFICACION_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
