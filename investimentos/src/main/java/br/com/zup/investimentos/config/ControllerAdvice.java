package br.com.zup.investimentos.config;

import br.com.zup.investimentos.investimento.exceptions.InvestimentoAltoRiscoMenorQueCincoMilException;
import br.com.zup.investimentos.investimento.exceptions.RiscoInvalidoException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
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

    @ExceptionHandler(InvestimentoAltoRiscoMenorQueCincoMilException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro tratarInvestimentoAltoRiscoMenorQueCincoMil(InvestimentoAltoRiscoMenorQueCincoMilException excessao){
        return new MensagemErro(excessao.getMessage());

    }

    @ExceptionHandler(RiscoInvalidoException.class)
    public MensagemErro tratarRiscoinvalido(RiscoInvalidoException excessao){
        return new MensagemErro(excessao.getMessage());
    }

    /*
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MensagemErro tratarRiscoNaoReconhecido (){
        return new MensagemErro("Risco não reconhecido");
    }
*/
}
