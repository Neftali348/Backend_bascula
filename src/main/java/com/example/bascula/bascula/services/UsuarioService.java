package com.example.bascula.bascula.services;

import com.example.bascula.bascula.models.Usuarios;
import com.example.bascula.bascula.repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public List<Usuarios> findAll(){
        return usuariosRepository.findAll();
    }
}
