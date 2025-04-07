package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Usuario;
import com.example.APIClassRoom.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;

    //GUARDAR

    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception {
        try {
            return this.repositorio.save( datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
        }

    //MODIFICAR

    }


