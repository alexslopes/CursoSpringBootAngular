package io.github.alexslopes.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Getter@Setter//retira a necessidad de criar funções gets e sets (para usar os metodos na ide é necessario instalar plugin lombok na ide).
@Data//Alem de gets e sets, cria toString e contrutos com parametros  obrigatórios
@NoArgsConstructor//Construtor vazio
@AllArgsConstructor//Gera um cnstrutor com todos argumentos
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist//Antes de inserir no banco de dados, executa o método
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }
}
