package io.github.alexslopes.clientes.rest;

import io.github.alexslopes.clientes.model.entity.Cliente;
import io.github.alexslopes.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController//Responsável por ter retorno rest
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public  ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping//mapea o método para uma requisição post
    @ResponseStatus(HttpStatus.CREATED)//retorna o codigo de status
    public Cliente salvar( @RequestBody Cliente cLiente){//notation que indica que o objeto json vem no corpo da requisição
        return repository.save(cLiente);
    }

    @GetMapping("{id}")
    public Cliente acharPorID( @PathVariable Integer id ){
        return repository.findById(id).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }
}
