package com.proyecto.banco.controllers;

import com.proyecto.banco.dtos.AutenticacionFilter;
import com.proyecto.banco.models.Usuarios;
import com.proyecto.banco.services.AutenticacionService;
import com.proyecto.banco.utils.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/log")
@CrossOrigin(origins = "http://localhost:4200") // Permite llamadas de Angular
public class LoginController {

    @Autowired
    private AutenticacionService autenticacionService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AutenticacionFilter filter) {

        // 🔍 Depuración: mostrar lo que recibe el backend
        System.out.println("===== DEBUG LOGIN =====");
        System.out.println("Correo recibido: " + filter.getCorreo());
        System.out.println("Password recibido: " + filter.getPassword());

        Usuarios usuarioValidado = autenticacionService.autenticar(filter);

        if (usuarioValidado == null) {
            System.out.println("❌ Credenciales inválidas para: " + filter.getCorreo());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }

        // Generar token JWT
        String token = jwtUtil.generarToken(usuarioValidado);

        // Convertir el rol a una lista con un solo elemento (en minúsculas, opcional)
        List<String> roles = Collections.singletonList(usuarioValidado.getRol().name().toLowerCase());

        System.out.println("✅ Usuario autenticado: " + usuarioValidado.getCorreo());
        System.out.println("Token generado: " + token);

        // Crear respuesta con token y datos útiles (email, roles, etc)
        return ResponseEntity.ok(new LoginResponse(token, usuarioValidado.getCorreo(), roles));
    }

    // Clase interna para respuesta
    static class LoginResponse {
        private String token;
        private String email;
        private List<String> roles;

        public LoginResponse(String token, String email, List<String> roles) {
            this.token = token;
            this.email = email;
            this.roles = roles;
        }

        // Getters
        public String getToken() { return token; }
        public String getEmail() { return email; }
        public List<String> getRoles() { return roles; }
    }
}
