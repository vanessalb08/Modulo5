package br.com.zup.lead.dtos;

import java.util.Objects;

public class ProdutoDTO {
    private String nomeProduto;
    private double valor;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nomeProduto, double valor) {
        this.nomeProduto = nomeProduto;
        this.valor = valor;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoDTO that = (ProdutoDTO) o;
        return Double.compare(that.valor, valor) == 0 && Objects.equals(nomeProduto, that.nomeProduto);
    }

}
