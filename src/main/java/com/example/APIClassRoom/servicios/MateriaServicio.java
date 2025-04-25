package com.example.APIClassRoom.servicios;

import com.example.APIClassRoom.ayudas.MensajesAPI;
import com.example.APIClassRoom.modelos.Materia;
import com.example.APIClassRoom.repositorio.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }


        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }


    }
    //BUSCAR ID
    public Materia buscarMateriaPorId(Integer id) throws Exception {
        try {
            Optional<Materia> materiaBuscado = this.repositorio.findById(id);
            if (materiaBuscado.isPresent()) {
                return materiaBuscado.get();
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR TODOS
    public List<Materia> buscarTodasLasMaterias() throws Exception {
        try {
            return this.repositorio.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    //ELIMINAR
    public boolean eliminarMateria(Integer id) throws Exception {
        try {
            Optional<Materia> materiaBuscado = this.repositorio.findById(id);
            if (materiaBuscado.isPresent()) {
                this.repositorio.delete(materiaBuscado.get());
                return true;
            } else {
                throw new Exception(MensajesAPI.MATERIA_NO_ENCONTRADA.getTexto());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
