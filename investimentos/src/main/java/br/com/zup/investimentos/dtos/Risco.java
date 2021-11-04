package br.com.zup.investimentos.dtos;

public enum Risco {
    ALTO(0.25),
    MEDIO(0.15),
    BAIXO(0.05);

    private final double taxaDeRetorno;

    Risco(double taxaDeRetorno) {
        this.taxaDeRetorno = taxaDeRetorno;
    }

    public double getTaxaDeRetorno() {
        return taxaDeRetorno;
    }
}
