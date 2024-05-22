package com.example.AtividadeAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exemplo1.model.Usuario;
import com.example.exemplo1.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }
    
    @PostMapping("/usuarios")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        try {
            return usuarioService.inserirUsuario(usuario);
        } catch (Exception e) {
            // Aqui você pode personalizar o tratamento de exceções conforme necessário
            return null;
        }
    }
}
