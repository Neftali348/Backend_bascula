package com.example.bascula.bascula.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Suponiendo que el id_rol es autoincremental
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    // Constructores
    public Rol() {}




    public Rol(String nombre) {
        this.nombre = nombre;
    }



    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
