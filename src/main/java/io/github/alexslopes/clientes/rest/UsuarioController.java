package io.github.alexslopes.clientes.rest;

import io.github.alexslopes.clientes.exception.UsuarioCadastradoException;
import io.github.alexslopes.clientes.model.entity.Usuario;
import io.github.alexslopes.clientes.model.repository.UsuarioRepository;
import io.github.alexslopes.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {


    private final  UsuarioService service;//Por esta usando RequiredArgsConstructor, necessita utilizar o final para injetar a dependencia

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
