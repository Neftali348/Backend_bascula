package com.example.bascula.bascula.repositories;

import com.example.bascula.bascula.enums.RoleList;
import com.example.bascula.bascula.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {


    Optional<Usuarios> findByNombre(String nombre);
    boolean existsByNombre(String nombre);
}
