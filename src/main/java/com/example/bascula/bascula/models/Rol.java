package com.example.bascula.bascula.models;

import com.example.bascula.bascula.enums.RoleList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles", schema = "bascula")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Suponiendo que el id_rol es autoincremental
    @Column(name = "id_roles")
    private Integer idRol;

    @Column(name = "nombre", length = 50, nullable = false)
    private RoleList nombre;


    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public RoleList getNombre() {
        return nombre;
    }

    public void setNombre(RoleList nombre) {
        this.nombre = nombre;
    }
}
