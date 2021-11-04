package br.com.zup.investimentos.config;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemErro> tratarExcessaoValidacao (MethodArgumentNotValidException excessao) {

        List<MensagemErro> mensagensErro = new ArrayList<>();
        for (FieldError fieldError : excessao.getFieldErrors()){
            mensagensErro.add(new MensagemErro(fieldError.getDefaultMessage()));
        }

        return mensagensErro;

    }
}
