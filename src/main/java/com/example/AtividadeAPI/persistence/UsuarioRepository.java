package com.example.exemplo1.persistence;

import org.springframework.data.repository.CrudRepository;
import com.example.exemplo1.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    // Aqui você pode adicionar métodos de consulta personalizados se necessário
}
