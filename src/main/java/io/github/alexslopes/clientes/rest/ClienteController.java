package io.github.alexslopes.clientes.rest;

import io.github.alexslopes.clientes.model.entity.Cliente;
import io.github.alexslopes.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController//Responsável por ter retorno rest
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public  ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> obterTodos() {
        return repository.findAll();
    }

    /*@Valid: permite fazer a validação no momento da requisição*/
    //@Request: Bodynotation que indica que o objeto json vem no corpo da requisição
    @PostMapping//mapea o método para uma requisição post
    @ResponseStatus(HttpStatus.CREATED)//retorna o codigo de status
    public Cliente salvar( @RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }

    //TODO:Documentar ResponseStatusException
    @GetMapping("{id}")
    public Cliente acharPorID( @PathVariable Integer id ){
        return repository.findById(id).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
    }

    //@PathVariable: obtem o valor passado pela url
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//Não tem conteúdo de retorno
    public void deletar( @PathVariable Integer id ){
        repository.findById(id).
                map( cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                }).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
    }

    @PutMapping("{id}")//Utilizado para atualizar recurso
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar( @PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado ) {
        repository.findById(id).
                map( cliente -> {
                    clienteAtualizado.setNome(clienteAtualizado.getNome());
                    clienteAtualizado.setCpf(clienteAtualizado.getCpf());
                    return repository.save(clienteAtualizado);
                }).
                orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado") );
    }
}
