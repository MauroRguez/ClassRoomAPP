package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Estudiante;
import com.example.APIClassRoom.servicios.EstudianteServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/estudiantes")
@Tag( name = "Servicios asociados a la gestion de estudiantes", description = "Servicios CRUD asociados a la gestion de estudiantes")
public class EstuduanteControlador {
    @Autowired
    EstudianteServicio servicio;
    //Controlador para guardar curso
    @PostMapping
    @Operation(
            summary = "Registro de un nuevo estudiante en BD",
            description = "Permite registrar un nuevo estudiante en la base de datos. Se debe enviar un objeto Estudiante con los datos requeridos."
    )
    public ResponseEntity<?> guardar(@RequestBody Estudiante datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarEstudiante(datosEnviadosPorElCliente));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para modificar curso
    @PutMapping("/{id}")
    @Operation(
            summary = "Modificación de un estudiante existente en BD",
            description = "Permite modificar los datos de un estudiante existente en la base de datos con el id"
    )
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Estudiante datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarEstudiante(id, datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
                        }
                    }
    //Controlador para buscar curso por id
    @GetMapping ("/{id}")
    @Operation(
            summary = "Búsqueda de un estudiante por ID",
            description = "Permite buscar un estudiante específico en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> buscarPorId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarEstudiantePorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar todos los cursos
    @GetMapping
    @Operation(
            summary = "Búsqueda de todos los estudiantes",
            description = "Permite buscar todos los estudiantes existentes en la base de datos"
    )
    public ResponseEntity<?> buscarTodos(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodosEstudiantes());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para eliminar curso
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminación de un estudiante existente en BD",
            description = "Permite eliminar un estudiante existente en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            this.servicio.eliminarEstudiante(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarEstudiante(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}
