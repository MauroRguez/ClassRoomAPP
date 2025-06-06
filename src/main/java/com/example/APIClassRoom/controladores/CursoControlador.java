package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Curso;
import com.example.APIClassRoom.servicios.CursoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@Tag (name = "Servicios asociados a la gestion de cursos", description = "Servicios CRUD asociados a la gestion de cursos")

public class CursoControlador {
    @Autowired
    CursoServicio servicio;

    //Controlador para guardar curso
    @PostMapping
    @Operation(
            summary = "Registro de un nuevo curso en BD",
            description = "Permite registrar un nuevo curso en la base de datos. Se debe enviar un objeto Curso con los datos requeridos."
    )
    public ResponseEntity<?> guardar(@RequestBody Curso datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarCurso(datosEnviadosPorElCliente));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para modificar curso
    @PutMapping("/{id}")
    @Operation(
            summary = "Modificación de un curso existente en BD",
            description = "Permite modificar los datos de un curso existente en la base de datos con el id"
    )
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Curso datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarCurso(id, datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
                        }
                    }
    //Controlador para buscar curso por id
    @GetMapping ("/{id}")
    @Operation(
            summary = "Búsqueda de un curso por ID",
            description = "Permite buscar un curso específico en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> buscarPorId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarCurso(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar todos los cursos
    @GetMapping
    @Operation(
            summary = "Búsqueda de todos los cursos en la BD",
            description = "Permite obtener una lista de todos los cursos registrados en la base de datos"
    )
    public ResponseEntity<?> buscarTodos(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodosCursos());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para eliminar curso
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminación de un curso existente en BD por ID",
            description = "Permite eliminar un curso existente en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarCurso(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

}
