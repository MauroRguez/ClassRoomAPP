package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Inscripcion;
import com.example.APIClassRoom.repositorio.IInscripcionRespositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
