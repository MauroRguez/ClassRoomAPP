package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Docente;
import com.example.APIClassRoom.repositorio.IDocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                    throw new Exception(MensajesAPI.DOCENTE_NO_ENCONTRADO.getTexto());
                }

            }catch (Exception error){
               throw  new Exception(error.getMessage());
            }
    }

    //BUSCAR ID

    public Docente buscarDocentePorId(Integer id) throws Exception{
            try{
                Optional<Docente> docenteQueBusco=this.Repositorio.findById(id);
                if(docenteQueBusco.isPresent()){
                    return docenteQueBusco.get();
                }else{
                    throw new Exception(MensajesAPI.DOCENTE_NO_ENCONTRADO.getTexto());
                }


            }catch (Exception error){
                throw new Exception(error.getMessage());
            }
    }


    // BUSCAR TODOS
    public List<Docente> buscarTodosDocentes() throws Exception{
            try{
                return this.Repositorio.findAll();
            }catch(Exception error){
                throw new Exception(error.getMessage());
            }
        }

    //ELIMINAR
    public boolean eliminarDocente(Integer id) throws Exception{

           try{
               Optional<Docente> docenteBuscado = this.Repositorio.findById(id);
               if (docenteBuscado.isPresent()) {
                     this.Repositorio.deleteById(id);
                     return true;


               }else{
                     throw new Exception(MensajesAPI.DOCENTE_NO_ENCONTRADO.getTexto());
               }


           } catch (Exception error){
               throw new Exception(error.getMessage());
           }

    }


}


