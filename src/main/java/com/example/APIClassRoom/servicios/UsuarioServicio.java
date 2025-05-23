package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Usuario;
import com.example.APIClassRoom.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    IUsuarioRepositorio repositorio;

    //GUARDAR

    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception {
        try {
            return this.repositorio.save(datosUsuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR

    public Usuario modificarUsuario(Integer id, Usuario datosUsuario) throws Exception {

        Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);

        try {
            if (usuarioBuscado.isPresent()) {
                usuarioBuscado.get().setNombre(datosUsuario.getNombre());
                usuarioBuscado.get().setCorreoElectronico(datosUsuario.getCorreoElectronico());
                usuarioBuscado.get().setContrasena(datosUsuario.getContrasena());
                usuarioBuscado.get().setTelefono(datosUsuario.getTelefono());

                return this.repositorio.save(usuarioBuscado.get());


            } else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    //BUSCAR ID
    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                return usuarioBuscado.get();
            } else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

    // BUSCAR TODOS

    public List<Usuario> buscarTodosLosUsuarios() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR
    public boolean eliminarUsuario(Integer id) throws Exception {
        try {
            Optional<Usuario> usuarioBuscado = this.repositorio.findById(id);
            if (usuarioBuscado.isPresent()) {
                this.repositorio.delete(usuarioBuscado.get());
                return true;
            } else {
                throw new Exception(MensajesAPI.USUARIO_NO_ENCONTRADO.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}

