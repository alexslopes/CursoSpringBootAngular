package io.github.alexslopes.clientes.rest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor//Cria construtor sem parametros
public class ServicoPrestadoDto {
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @NotEmpty(message = "{campo.preco.obrigatorio}")
    private String preco;

    @NotEmpty(message = "{campo.data.obrigatorio}")
    private String data;

    @NotNull(message = "{campo.cliente.obrigatorio}")
    private Integer idCliente;
}
