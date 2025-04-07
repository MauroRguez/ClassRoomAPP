package com.example.APIClassRoom.repositorio;

import com.example.APIClassRoom.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepositorio extends JpaRepository<Usuario,Integer> {
}
