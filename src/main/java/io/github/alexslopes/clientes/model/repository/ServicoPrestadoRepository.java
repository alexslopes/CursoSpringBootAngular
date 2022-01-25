package io.github.alexslopes.clientes.model.repository;

import io.github.alexslopes.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
