package io.github.alexslopes.clientes.model.repository;

import io.github.alexslopes.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//defini em JpaRepository a entidade e o tipo de chave que será o usado: CLiente e Integer respectivamente
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
