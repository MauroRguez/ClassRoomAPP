package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Docente;
import com.example.APIClassRoom.repositorio.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocenteServicio {

    @Autowired // Inyeccion de dependencias
    IDocenteRepositorio Repositorio;


    //GUARDAR
        public Docente guardarDocente(Docente datosDocente)throws Exception{
            try{
              return this.Repositorio.save(datosDocente);
            } catch (Exception error) {
                throw new Exception(error.getMessage());

            }
        }

    //MODIFICAR
    public Docente modificarDocente(Integer id, Docente datosDocente) throws Exception {
            try{
                //para midificar un docente primero se busca por id
                //JPA me devuelve un opcional(puede estar o no)

               Optional<Docente> docenteBuscado=this.Repositorio.findById(id);

               //apenas los busques prefgunta si esta o no esta
                if(docenteBuscado.isPresent()){
                    //si esta, se modifica
                   docenteBuscado.get().setEspecialidad(datosDocente.getEspecialidad());
                   return this.Repositorio.save(docenteBuscado.get());


                }else{
                    //si no esta, lanzamos una excepcion
                    throw new Exception("El docente no existe");
                }

            }catch (Exception error){
               throw  new Exception(error.getMessage());

            }

    }


    //BUSCAR ID

    // BUSCAR TODOS

    //ELIMINAR
}


