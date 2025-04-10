package com.example.bascula.bascula.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUsuariosDto {
    public String nombre;
    public String contrasenia;
}
