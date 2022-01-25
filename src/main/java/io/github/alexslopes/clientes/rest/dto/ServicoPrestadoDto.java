package io.github.alexslopes.clientes.rest.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;


@Data
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoDto {
    private String descricao;
    private String preco;
    private String data;
    private Integer idCliente;
}
