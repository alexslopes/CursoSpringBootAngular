package io.github.alexslopes.clientes.rest;

import io.github.alexslopes.clientes.model.entity.Cliente;
import io.github.alexslopes.clientes.model.entity.ServicoPrestado;
import io.github.alexslopes.clientes.model.repository.ClienteRepository;
import io.github.alexslopes.clientes.model.repository.ServicoPrestadoRepository;
import io.github.alexslopes.clientes.rest.dto.ServicoPrestadoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestaoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;

    @PostMapping
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDto dto) {
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        //Optional: pode retornar outro valor caso nulo
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        Cliente cliente =
                clienteRepository
                        .findById(idCliente)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( );
    }
}
