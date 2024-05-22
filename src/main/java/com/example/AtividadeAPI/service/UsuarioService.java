package com.example.AtividadeAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AtividadeAPI.model.Usuario;
import com.example.AtividadeAPI.persistence.UsuarioRepository;

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

    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario u = usuarioExistente.get();
            u.setNome(usuario.getNome());
            u.setLogin(usuario.getLogin());
            u.setEmail(usuario.getEmail());
            u.setSenha(usuario.getSenha()); // Considere fazer hash da senha aqui se necessário
            return usuarioRepository.save(u);
        } else {
            return null;
        }
    }

    public boolean excluirUsuario(Long id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
        if (usuarioExistente.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
