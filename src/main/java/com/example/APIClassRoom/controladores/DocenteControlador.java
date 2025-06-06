package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Docente;
import com.example.APIClassRoom.servicios.DocenteServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docentes")
@Tag(name="Servicios asociados a la gestion de docentes", description = "Servicios CRUD asociados al de docentes")

public class DocenteControlador {

    @Autowired
    DocenteServicio servicio;

    //Controlador para guardar un docente
    @PostMapping
    @Operation(
        summary="Registro de un nuevo docente en BD" , description = "Permite registrar un nuevo docente en la base de datos. Se debe enviar un objeto Docente con los datos requeridos.(id y especialidad)"

    )
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
    @Operation(
            summary = "Modificación de un docente existente en BD",description = "Permite modificar los datos de un docente existente en la base de datos con el id"
    )
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
    @Operation(
            summary = "Buscar un docente por su id", description = "Permite buscar un docente existente en la base de datos con el id"
    )
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
    @Operation(
            summary = "Buscar todos los docentes existentes en la BD", description = "Permite buscar todos los docentes existentes en la base de datos"
    )
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
@Operation(
        summary = "Eliminar un docente existente en BD por su ID", description = "Permite eliminar un docente existente en la base de datos con el id"
)
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