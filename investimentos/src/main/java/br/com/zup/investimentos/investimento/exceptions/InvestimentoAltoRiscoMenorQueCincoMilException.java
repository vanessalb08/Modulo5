package br.com.zup.investimentos.investimento.exceptions;

public class InvestimentoAltoRiscoMenorQueCincoMilException extends RuntimeException{

    public InvestimentoAltoRiscoMenorQueCincoMilException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
