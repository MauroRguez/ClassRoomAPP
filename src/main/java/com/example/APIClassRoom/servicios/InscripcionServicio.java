package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Inscripcion;
import com.example.APIClassRoom.repositorio.IInscripcionRespositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscripcionServicio {
    @Autowired
    IInscripcionRespositorio repositorio;

    //GUARDAR
    public Inscripcion guardarInscripcion(Inscripcion datosInscripcion) throws Exception {
        try {
            return this.repositorio.save(datosInscripcion);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    //MODIFICAR
    public Inscripcion modificarInscripcion (Integer id, Inscripcion datosInscripcion) throws Exception {
        try {
            //para modificar una inscripcion primero se busca por id
            //JPA me devuelve un opcional(puede estar o no)
            Optional<Inscripcion> inscripcionBuscada = this.repositorio.findById(id);

            //apenas los busques pregunta si esta o no esta
            if (inscripcionBuscada.isPresent()) {
                //si esta, se modifica
                inscripcionBuscada.get().setFechaInscripcion(datosInscripcion.getFechaInscripcion());

                return this.repositorio.save(inscripcionBuscada.get());

            } else {
                //si no esta, lanzamos una excepcion
                throw new Exception("La inscripcion no existe");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


}
