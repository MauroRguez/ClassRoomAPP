package com.example.APIClassRoom.controladores;


import com.example.APIClassRoom.modelos.Asistencia;
import com.example.APIClassRoom.servicios.AsistenciaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencias")
@Tag(name = "Servicios asociados a la gestion de asistencias", description = "Servicios CRUD asociados a la gestion de asistencias")
public class AsistenciaControlador {
    @Autowired
    AsistenciaServicio servicio;

    //controlador para guardar asistencia
    @PostMapping
    @Operation(
            summary = "Registro de una nueva asistencia en BD",
            description = "Permite registrar una nueva asistencia en la base de datos. Se debe enviar un objeto Asistencia con los datos requeridos."
    )
    public ResponseEntity<?> guardar(@RequestBody Asistencia datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarAsistencia(datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
        //Controlador para modificar asistencia
        @PutMapping("/{id}")
        @Operation(
                summary = "Modificación de una asistencia existente en BD",
                description = "Permite modificar los datos de una asistencia existente en la base de datos con el id"
        )
        public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Asistencia datosEnviadosPorElCliente) {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.servicio.modificarAsistencia(id, datosEnviadosPorElCliente));
            } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
            }
        }
        //Controlador para buscar asistencia por id
        @GetMapping("/{id}")
        @Operation(
                summary = "Búsqueda de una asistencia por ID",
                description = "Permite buscar una asistencia específica en la base de datos utilizando su ID"
        )
        public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
            try {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(this.servicio.buscarAsistenciaPorId(id));
            } catch (Exception errorAPI) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(errorAPI.getMessage());
            }
        }
        //Controlador para buscar todas las asistencias
    @GetMapping
    @Operation(
                summary = "Búsqueda de todas las asistencias",
                description = "Permite obtener una lista de todas las asistencias registradas en la base de datos"
     )
    public ResponseEntity<?> buscarTodo() {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodasAsistencias());
        }catch (Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage( ));
        }
   }

        //Controlador para eliminar asistencia

@DeleteMapping("/{id}")
@Operation(
        summary = "Eliminación de una asistencia por ID",
        description = "Permite eliminar una asistencia específica de la base de datos utilizando su ID"
)
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            this.servicio.eliminarAsistencia(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarAsistencia(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }


}