package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Asistencia;
import com.example.APIClassRoom.repositorio.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }


        }catch(Exception error){
            throw new Exception(error.getMessage());

        }
     }
    //BUSCAR ID
    public Asistencia buscarAsistenciaPorId(Integer id) throws Exception{
        try {
            Optional<Asistencia> asistenciaBuscado = this.Repositorio.findById(id);
            if(asistenciaBuscado.isPresent()) {
                return asistenciaBuscado.get();
            }else {
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    // BUSCAR TODOS

    public List<Asistencia> buscarTodasAsistencias() throws Exception{
        try {
            return this.Repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR

    public boolean eliminarAsistencia(Integer id) throws Exception{
        try {
            Optional<Asistencia> asistenciaBuscado = this.Repositorio.findById(id);
            if(asistenciaBuscado.isPresent()){
                this.Repositorio.deleteById(id);
                return true;
            }else{
                throw new Exception(MensajesAPI.ASISTENCIA_NO_ENCONTRADA.getTexto());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


}
