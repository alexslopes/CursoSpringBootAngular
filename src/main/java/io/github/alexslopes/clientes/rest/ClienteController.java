package io.github.alexslopes.clientes.rest;

import io.github.alexslopes.clientes.model.entity.Cliente;
import io.github.alexslopes.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

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
    public Cliente salvar( @RequestBody @Valid/*permite fazer a validação no momento da requisição*/ Cliente cLiente){//notation que indica que o objeto json vem no corpo da requisição
        return repository.save(cLiente);
    }

    @GetMapping("{id}")
    public Cliente acharPorID( @PathVariable Integer id ){
        return repository.findById(id).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//Não te conteúdo de retorno
    public void deletar( @PathVariable Integer id ){
        repository.findById(id).
                map( cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                }).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id, @RequestBody Cliente clienteAtualizado ) {
        repository.findById(id).
                map( cliente -> {
                    clienteAtualizado.setNome(clienteAtualizado.getNome());
                    clienteAtualizado.setCpf(clienteAtualizado.getCpf());
                    return repository.save(clienteAtualizado);
                }).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND) );
    }
}
