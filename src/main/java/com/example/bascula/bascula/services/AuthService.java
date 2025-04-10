package com.example.bascula.bascula.services;

import com.example.bascula.bascula.dtos.NewUsuarioDto;
import com.example.bascula.bascula.enums.RoleList;
import com.example.bascula.bascula.jwt.JwtUtil;

import com.example.bascula.bascula.models.Rol;
import com.example.bascula.bascula.models.Usuarios;
import com.example.bascula.bascula.repositories.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//autenticar y crear nuevos usuarios
@Service
public class AuthService {
    private final UsuarioService usuarioService;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @Autowired
    public AuthService(UsuarioService usuarioService, RolRepository rolRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.usuarioService = usuarioService;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

    public void registerUser(NewUsuarioDto newUsuarioDto) {
        if (usuarioService.existsByNombre(newUsuarioDto.getNombre())) {
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }

        Rol rol= rolRepository.findByNombre(RoleList.ROLE_USER).orElseThrow(()-> new IllegalArgumentException("No existe el rol"));
        Usuarios usuarios = new Usuarios(newUsuarioDto.getNombre(), passwordEncoder.encode(newUsuarioDto.getContrasenia()),rol );
        usuarioService.save(usuarios);

    }
}
