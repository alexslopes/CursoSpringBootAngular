package io.github.alexslopes.clientes.model.repository;

import io.github.alexslopes.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);

    //select from usuario
    boolean existsByUsername(String username);
}
