package com.example.bascula.bascula.models;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Suponiendo que id_usuario es autoincremental
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "contrasenia", length = 50, nullable = false)
    private String contrasenia;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false) // Relación con Rol
    private Rol rol;

    // Constructores
    public Usuarios() {}

    public Usuarios(String nombre, String contrasenia, Rol rol) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    // Getters y Setters
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
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
