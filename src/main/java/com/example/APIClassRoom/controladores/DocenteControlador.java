package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Docente;
import com.example.APIClassRoom.servicios.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docentes")


public class DocenteControlador {

    @Autowired
    DocenteServicio servicio;

    //Controlador para guardar un docente
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody Docente datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarDocente(datosEnviadosPorElCliente));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

    //Controlador para modificar un docente

    @PutMapping("/{id}")

    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Docente datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarDocente(id, datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
                        }
                    }




    //Controlador para buscar un docente por id

@GetMapping ("/{id}")
    public ResponseEntity<?> buscarPorId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarDocentePorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }


    }

    //Controlador para buscar todos los docentes
    @GetMapping
    public ResponseEntity<?> buscarTodo(){
        try {
            return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.buscarTodosDocentes());
    } catch (Exception errorAPI) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorAPI.getMessage());
    }

    }


//Contorolador para eliminar un docente
@DeleteMapping("/{id}")
public ResponseEntity<?> eliminar (@PathVariable Integer id){
    try {
        this.servicio.eliminarDocente(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.servicio.eliminarDocente(id));
    } catch (Exception errorAPI) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorAPI.getMessage());
    }
}


}