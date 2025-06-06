package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Materia;
import com.example.APIClassRoom.servicios.MateriaServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materias")
@Tag( name = "Servicios asociados a la gestión de materias", description = "Servicios CRUD asociados a la gestión de materias")
public class MateriaControlador {
    @Autowired
    MateriaServicio servicio;
    //Controlador para guardar curso
    @PostMapping
    @Operation(
            summary = "Registro de una nueva materia en BD",
            description = "Permite registrar una nueva materia en la base de datos. Se debe enviar un objeto Materia con los datos requeridos."
    )
    public ResponseEntity<?> guardar(@RequestBody Materia datosEnviadosPorElCliente){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarMateria(datosEnviadosPorElCliente));
        }catch(Exception errorAPI){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para modificar curso
    @PutMapping("/{id}")
    @Operation(
            summary = "Modificación de una materia existente en BD",
            description = "Permite modificar los datos de una materia existente en la base de datos con el id"
    )
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Materia datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarMateria(id, datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar curso por id
    @GetMapping ("/{id}")
    @Operation(
            summary = "Búsqueda de una materia por ID",
            description = "Permite buscar una materia específica en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> buscarPorId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarMateriaPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar todos los cursos
    @GetMapping
    @Operation(
            summary = "Búsqueda de todas las materias",
            description = "Permite buscar todas las materias registradas en la base de datos"
    )
    public ResponseEntity<?> buscarTodos(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodasLasMaterias());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para eliminar curso
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminación de una materia por ID",
            description = "Permite eliminar una materia específica de la base de datos utilizando su ID"
    )
    public ResponseEntity<?> eliminar(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarMateria(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

}
