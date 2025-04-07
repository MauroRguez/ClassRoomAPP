package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Asistencia;
import com.example.APIClassRoom.repositorio.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsitenciaServicio {

    @Autowired
    IAsistenciaRepositorio Repositorio;

    //GUARDAR
    public Asistencia guardarAsistencia(Asistencia datosAsistencia) throws Exception {
        try {
            return this.Repositorio.save(datosAsistencia);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR
     public Asistencia modificarAsistencia(Integer id, Asistencia datosAsistencia) throws Exception{
        try {
            Optional<Asistencia> asistenciaBuscado = this.Repositorio.findById(id);

            if(asistenciaBuscado.isPresent()){
                asistenciaBuscado.get().setEstado(datosAsistencia.getEstado());
                asistenciaBuscado.get().setFecha(datosAsistencia.getFecha());
                return this.Repositorio.save(asistenciaBuscado.get());

            }else{
                throw new Exception("No existen datos");
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
     }




}
