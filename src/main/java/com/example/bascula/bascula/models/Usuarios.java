package com.example.bascula.bascula.models;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "usuarios", schema = "bascula")
public class Usuarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Suponiendo que id_usuario es autoincremental
    @Column(name = "id_usuario")
    private long idUsuario;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "contrasenia", length = 50, nullable = false)
    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "id_roles", nullable = false) // Relación con Rol
    private Rol rol;

    // Constructores
    public Usuarios() {}

    public Usuarios(String nombre, String contrasenia, Rol rol) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }



    // Getters y Setters
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
