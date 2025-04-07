package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.modelos.Materia;
import com.example.APIClassRoom.repositorio.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
