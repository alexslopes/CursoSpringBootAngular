package io.github.alexslopes.clientes.rest;

import io.github.alexslopes.cliente.exception.UsuarioCadastradoException;
import io.github.alexslopes.clientes.model.entity.Usuario;
import io.github.alexslopes.clientes.model.repository.UsuarioRepository;
import io.github.alexslopes.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar( @RequestBody @Valid Usuario usuario) {
        try {
            service.salvar(usuario);
        }catch (UsuarioCadastradoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());//Lançado no controller pois aqui é o reponsável pelo usuário final
        }
    }
}
