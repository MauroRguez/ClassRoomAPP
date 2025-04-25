package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Inscripcion;
import com.example.APIClassRoom.repositorio.IInscripcionRespositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    //BUSCAR ID
    public Inscripcion buscarInscripcionPorId(Integer id) throws Exception {
        try {
            Optional<Inscripcion> inscripcionBuscada = this.repositorio.findById(id);
            if (inscripcionBuscada.isPresent()) {
                return inscripcionBuscada.get();
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // BUSCAR TODOS

    public List<Inscripcion> buscarTodasInscripciones() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR

    public boolean eliminarInscripcion(Integer id) throws Exception {
        try {
            Optional<Inscripcion> inscripcionBuscada = this.repositorio.findById(id);
            if (inscripcionBuscada.isPresent()) {
                this.repositorio.delete(inscripcionBuscada.get());
                return true;
            } else {
                throw new Exception(MensajesAPI.INSCRIPCION_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
