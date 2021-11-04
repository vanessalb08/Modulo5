package br.com.zup.investimentos.investimento.exceptions;

public class RiscoInvalidoException extends RuntimeException {
    public RiscoInvalidoException(String message) {
        super(message);
    }
}
