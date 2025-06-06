package com.example.APIClassRoom.controladores;

import com.example.APIClassRoom.modelos.Usuario;
import com.example.APIClassRoom.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@Tag( name = "Servicios asociados a la gestión de usuarios", description = "Servicios CRUD asociados a la gestión de usuarios")

public class UsuarioControlador {
    @Autowired
    UsuarioServicio servicio;
    //Controlador para guardar curso
    @PostMapping
    @Operation(
            summary = "Registro de un nuevo usuario en BD",
            description = "Permite registrar un nuevo usuario en la base de datos. Se debe enviar un objeto Usuario con los datos requeridos."
    )
    public ResponseEntity<?> guardar(@RequestBody Usuario datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.servicio.guardarUsuario(datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para modificar curso
    @PutMapping("/{id}")
    @Operation(
            summary = "Modificación de un usuario existente en BD",
            description = "Permite modificar los datos de un usuario existente en la base de datos con el id"
    )
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Usuario datosEnviadosPorElCliente) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.modificarUsuario(id, datosEnviadosPorElCliente));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar curso por id
    @GetMapping("/{id}")
    @Operation(
            summary = "Búsqueda de un usuario por ID",
            description = "Permite buscar un usuario específico en la base de datos utilizando su ID"
    )
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarUsuarioPorId(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para buscar todos los cursos
    @GetMapping
    @Operation(
            summary = "Búsqueda de todos los usuarios",
            description = "Permite buscar todos los usuarios registrados en la base de datos"
    )
    public ResponseEntity<?> buscarTodos() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.buscarTodosLosUsuarios());
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }
    //Controlador para eliminar curso
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminación de un usuario por ID",
            description = "Permite eliminar un usuario específico de la base de datos utilizando su ID"
    )
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.servicio.eliminarUsuario(id));
        } catch (Exception errorAPI) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorAPI.getMessage());
        }
    }

}
