package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Curso;
import com.example.APIClassRoom.repositorio.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {

    @Autowired
    ICursoRepositorio Repositorio;

    //GUARDAR
    public Curso guardarCurso(Curso datosCurso) throws Exception {
        try {
            return  this.Repositorio.save(datosCurso);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //MODIFICAR

    public Curso modificarCurso(Integer id, Curso datosCurso) throws Exception{

        try{
            Optional<Curso> cursoBuscado=this.Repositorio.findById(id);

            if(cursoBuscado.isPresent()){
                cursoBuscado.get().setNombre(datosCurso.getNombre());

                return this.Repositorio.save(cursoBuscado.get());
            }else{
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    //BUSCAR ID
    public Curso buscarCurso(Integer id) throws Exception{
        try {
            Optional<Curso> cursoBuscado = this.Repositorio.findById(id);
            if(cursoBuscado.isPresent()) {
                return cursoBuscado.get();
            }else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

    // BUSCAR TODOS
    public List<Curso> buscarTodosCursos() throws Exception{
        try {
            return this.Repositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //ELIMINAR

public boolean eliminarCurso(Integer id) throws Exception{
        try {
            Optional<Curso> cursoBuscado = this.Repositorio.findById(id);
            if(cursoBuscado.isPresent()) {
                this.Repositorio.deleteById(id);
                return true;
            }else {
                throw new Exception(MensajesAPI.CURSO_NO_ENCONTRADO.getTexto());
            }

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }
    }

}
