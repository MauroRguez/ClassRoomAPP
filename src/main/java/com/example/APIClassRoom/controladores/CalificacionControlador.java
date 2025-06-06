package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Calificacion;
import com.example.APIClassRoom.servicios.CalificacionServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calificaciones")
@Tag( name = "Servicios asociados a la gestion de calificaciones", description = "Servicios CRUD asociados a la gestion de calificaciones")
public class CalificacionControlador {
    @Autowired
    CalificacionServicio servicio;

    //Controlador para guardar calificacion
    @PostMapping
    @Operation(
            summary = "Registro de una nueva calificación en BD",
            description = "Permite registrar una nueva calificación en la base de datos. Se debe enviar un objeto Calificacion con los datos requeridos."
    )
    public ResponseEntity<?> guardar(@RequestBody Calificacion datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarCalificacion(datosEnviadosPorElCliente));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para modificar calificacion
    @PutMapping("/{id}")
    @Operation(
            summary = "Modificación de una calificación existente en BD",
            description = "Permite modificar los datos de una calificación existente en la base de datos con el id"
    )
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Calificacion datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarCalificacion(id, datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
                        }
                    }
    //Controlador para buscar calificacion por id
    @GetMapping("/{id}")
    @Operation(
            summary = "Búsqueda de una calificación por ID",
            description = "Permite buscar una calificación específica en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> buscarPorId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarCalificacionPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar todas las calificaciones
    @GetMapping
    @Operation(
            summary = "Búsqueda de todas las calificaciones existentes en BD",
            description = "Permite obtener una lista de todas las calificaciones registradas en la base de datos"
    )
    public ResponseEntity<?> buscarTodo() {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodasCalificaciones());
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para eliminar calificacion
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminación de una calificación existente en BD por ID",
            description = "Permite eliminar una calificación existente en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarCalificacion(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
}
