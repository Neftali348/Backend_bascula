package com.example.bascula.bascula.controllers;

import com.example.bascula.bascula.models.Usuarios;
import com.example.bascula.bascula.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bascula")
public class UsuariosRest {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping({"/usuarios"})
    public List<Usuarios> getAllUsuarios(){
        return usuarioService.findAll();
    }
}
