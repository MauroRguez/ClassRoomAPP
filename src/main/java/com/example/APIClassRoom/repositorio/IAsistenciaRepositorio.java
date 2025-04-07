package com.example.APIClassRoom.repositorio;


import com.example.APIClassRoom.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {


}
