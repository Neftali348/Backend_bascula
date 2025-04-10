package com.example.bascula.bascula.repositories;

import com.example.bascula.bascula.enums.RoleList;
import com.example.bascula.bascula.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByNombre(RoleList nombre);
}
