package com.example.exemplo1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exemplo1.model.Usuario;
import com.example.exemplo1.persistence.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario inserirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
