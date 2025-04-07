package com.example.APIClassRoom.repositorio;

import com.example.APIClassRoom.modelos.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInscripcionRespositorio extends JpaRepository<Inscripcion,Integer> {

}
