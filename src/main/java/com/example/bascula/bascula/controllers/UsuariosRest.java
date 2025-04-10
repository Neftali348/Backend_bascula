package com.example.bascula.bascula.controllers;

import com.example.bascula.bascula.models.Usuarios;
import com.example.bascula.bascula.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde el frontend
public class UsuariosRest {

    @Autowired
    private UsuarioService usuarioService;



}