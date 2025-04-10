package com.example.bascula.bascula.services;

import com.example.bascula.bascula.models.Usuarios;
import com.example.bascula.bascula.repositories.UsuariosRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@NoArgsConstructor
@Service
public class UsuarioService implements UserDetailsService{
    @Autowired
    private UsuariosRepository usuariosRepository;
  /*
    public  UsuarioService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }
    */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios user = usuariosRepository.findByNombre(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        SimpleGrantedAuthority Authority = new SimpleGrantedAuthority(user.getRol().getNombre().toString());
        return new org.springframework.security.core.userdetails.User(
                user.getNombre(),
                user.getContrasenia(),
                Collections.singleton(Authority)
        );
    }

    public boolean existsByNombre(String nombre) {
        return usuariosRepository.existsByNombre(nombre);
    }

    public void save(Usuarios usuarios) {
        usuariosRepository.save(usuarios);
    }


}