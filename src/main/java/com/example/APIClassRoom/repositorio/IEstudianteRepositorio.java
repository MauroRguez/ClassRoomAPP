package com.example.APIClassRoom.repositorio;

import com.example.APIClassRoom.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepositorio extends JpaRepository<Estudiante,Integer> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
