package io.github.alexslopes.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
//@Getter@Setter//retira a necessidade de criar funções gets e sets (para usar os metodos na ide é necessario instalar plugin lombok na ide).
@Data//Alem de gets e sets, cria toString e construtor sem e com parametros  obrigatórios
@NoArgsConstructor//Construtor vazio
@AllArgsConstructor//Gera um construtor com todos argumentos
@Builder//Da acesso ao builder da classe
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist//Antes de inserir no banco de dados, executa o método
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
