package br.com.zup.investimentos.dtos;

public enum Risco {
    ALTO(0.025),
    MEDIO(0.015),
    BAIXO(0.005);

    private final double taxaDeRetorno;

    Risco(double taxaDeRetorno) {
        this.taxaDeRetorno = taxaDeRetorno;
    }

    public double getTaxaDeRetorno() {
        return taxaDeRetorno;
    }
}
