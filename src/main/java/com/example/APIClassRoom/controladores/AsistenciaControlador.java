package com.example.APIClassRoom.controladores;


import com.example.APIClassRoom.modelos.Asistencia;
import com.example.APIClassRoom.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaControlador {
    @Autowired
    AsistenciaServicio servicio;

    //controlador para guardar asistencia
    @PostMapping
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