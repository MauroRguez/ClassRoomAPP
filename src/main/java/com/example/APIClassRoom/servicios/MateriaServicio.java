package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Materia;
import com.example.APIClassRoom.repositorio.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MateriaServicio {
    @Autowired
    IMateriaRepositorio repositorio;

    //GUARDAR
    public Materia guardarMateria(Materia datosMateria) throws Exception{
        try{
            return this.repositorio.save(datosMateria);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    //MODIFICAR
    public Materia modificarMateria(Integer id,Materia datosMateria) throws Exception {

        Optional<Materia> materiaBuscado = this.repositorio.findById(id);

        try {
            if (materiaBuscado.isPresent()) {
                materiaBuscado.get().setNombre(datosMateria.getNombre());
                return this.repositorio.save(materiaBuscado.get());
            } else {
                throw new Exception("No se encontro Materia");
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }


}
