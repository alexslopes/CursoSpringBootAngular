package io.github.alexslopes.clientes.model.repository;

import io.github.alexslopes.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
