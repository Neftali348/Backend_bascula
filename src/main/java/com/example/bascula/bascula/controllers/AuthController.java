package com.example.bascula.bascula.controllers;


import com.example.bascula.bascula.dtos.LoginUsuariosDto;
import com.example.bascula.bascula.dtos.NewUsuarioDto;
import com.example.bascula.bascula.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@Valid @RequestBody LoginUsuariosDto loginUsuariosDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Revise sus credenciales");
        }
        try{
            String jwt = authService.authenticate(loginUsuariosDto.nombre, loginUsuariosDto.getContrasenia());
            return ResponseEntity.ok(jwt);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Revise sus credenciales");
        }
    }



    @PostMapping("/registrar")
    public ResponseEntity<String> register(@Valid @RequestBody NewUsuarioDto newUsuarioDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Revise los campos");
        }
        try{
            authService.registerUser(newUsuarioDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/check-auth")
    public ResponseEntity<String> checkAuth() {
        return ResponseEntity.ok().body("Autenticado");
    }

}
