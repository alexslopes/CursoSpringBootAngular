package io.github.alexslopes.clientes;

import io.github.alexslopes.clientes.model.entity.Cliente;
import io.github.alexslopes.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//Annotation que indica a classe que inicia a aplicação
public class ClientesApplication {

    /*@Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {
            Cliente cliente = Cliente.builder().cpf("00000000000").nome("Fulano").build();//gera instancia de cliente com os dados
            repository.save(cliente);
        };
    }*/

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}
