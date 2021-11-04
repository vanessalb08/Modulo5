package br.com.zup.investimentos.dtos;

public class MontanteDTO {
    private double valorInvestido;
    private double valorTotalDolucro;
    private double valorTotal;

    public MontanteDTO() {
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public double getValorTotalDolucro() {
        return valorTotalDolucro;
    }

    public void setValorTotalDolucro(double valorTotalDolucro) {
        this.valorTotalDolucro = valorTotalDolucro;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
