package com.example.APIClassRoom.controladores;


import com.example.APIClassRoom.modelos.Inscripcion;
import com.example.APIClassRoom.servicios.InscripcionServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripciones")
@Tag(name = "Servicios asociados a la gestión de inscripciones", description = "Servicios CRUD asociados a la gestión de inscripciones")
public class InscripcionControlador {
    @Autowired
    InscripcionServicio servicio;

    //Controlador para guardar curso
    @PostMapping
    @Operation(
            summary = "Registro de una nueva inscripción en BD",
            description = "Permite registrar una nueva inscripción en la base de datos. Se debe enviar un objeto Inscripcion con los datos requeridos."
    )
    public ResponseEntity<?> guardar(@RequestBody Inscripcion datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED )
                    .body(this.servicio.guardarInscripcion(datosEnviadosPorElCliente));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para modificar curso
    @PutMapping("/{id}")
    @Operation(
            summary = "Modificación de una inscripción existente en BD",
            description = "Permite modificar los datos de una inscripción existente en la base de datos con el id"
    )
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Inscripcion datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarInscripcion(id, datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
                        }
                    }
    //Controlador para buscar curso por id
    @GetMapping ("/{id}")
    @Operation(
            summary = "Búsqueda de una inscripción por ID",
            description = "Permite buscar una inscripción específica en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> buscarPorId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarInscripcionPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar todos los cursos
    @GetMapping
    @Operation(
            summary = "Búsqueda de todas las inscripciones",
            description = "Permite buscar todas las inscripciones registradas en la base de datos"
    )
    public ResponseEntity<?> buscarTodos(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodasInscripciones());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para eliminar curso
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminación de una inscripción existente en BD",
            description = "Permite eliminar una inscripción existente en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarInscripcion(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}

