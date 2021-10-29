package br.com.zup.lead;

import java.util.List;

public class LeadDTO {
    private String email;
    private String nome;
    private String telefone;
    private List<ProdutoDTO> produtoDTOList;

    public LeadDTO() {
    }

    public LeadDTO(String email, String nome, String telefone, List<ProdutoDTO> produtoDTOList) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.produtoDTOList = produtoDTOList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<ProdutoDTO> getProdutoDTOList() {
        return produtoDTOList;
    }

    public void setProdutoDTOList(List<ProdutoDTO> produtoDTOList) {
        this.produtoDTOList = produtoDTOList;
    }
}
