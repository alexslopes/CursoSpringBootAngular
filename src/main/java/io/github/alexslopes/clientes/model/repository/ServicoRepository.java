package io.github.alexslopes.clientes.model.repository;

import io.github.alexslopes.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
