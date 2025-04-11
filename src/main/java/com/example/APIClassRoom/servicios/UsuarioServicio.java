package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Usuario;
import com.example.APIClassRoom.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Usuario modificarUsuario (Integer id,Usuario datosUsuario) throws Exception{

        Optional<Usuario> usuarioBuscado=this.repositorio.findById(id);

        try {
            if(usuarioBuscado.isPresent()){
                usuarioBuscado.get().setNombre(datosUsuario.getNombre());
               return this.repositorio.save(usuarioBuscado.get());


            }else{
                throw  new Exception("No se encontro Usuario");
            }
        }catch (Exception error){
             throw  new Exception(error.getMessage());
        }

      }

    }


