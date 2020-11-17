package io.github.alexslopes.clientes.rest;

import io.github.alexslopes.clientes.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice//Recebe erros e modifica retorno de requisições
public class ApplicationControllerAdvice {

    //Notation executa quando exception ocorre
    @ExceptionHandler(MethodArgumentNotValidException.class)//exception que identifica erro de validação
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErros(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<String> messages =  bindingResult.getAllErrors()//Obtém resultados da validação
                .stream()
                .map( objectError -> objectError.getDefaultMessage() )
                .collect(Collectors.toList());

        return new ApiErrors(messages);
    }

    //ResponseEntity: retorna objeto da forma que deseja ex: como corpo da resposta, codigo de status...
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handlerResponseStatusException(ResponseStatusException ex){
        String mensagemErro = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErrors apiErrors = new ApiErrors(mensagemErro);
        return new ResponseEntity(apiErrors, codigoStatus);
    }
}
