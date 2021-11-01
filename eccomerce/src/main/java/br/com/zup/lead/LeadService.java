package br.com.zup.lead;

import br.com.zup.lead.dtos.LeadDTO;
import br.com.zup.lead.dtos.ProdutoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {

    private List<LeadDTO> leadsList = new ArrayList<>();

    public List<LeadDTO> exibirLeads() {
        return leadsList;
    }

    public void adicionarLead(LeadDTO novoLead) {
        if (verificarEmailCadastrado(novoLead.getEmail())){
            verificarProdutoRepetido(novoLead);
            atualizarProdutosLead(novoLead);
        }
        else {
            leadsList.add(novoLead);
        }

    }

    //Verificar se o e-mail já está cadastrado
    public boolean verificarEmailCadastrado (String email){

        for (LeadDTO leadReferencia : leadsList){
            if (leadReferencia.getEmail().equals(email)){
                return true;
            }
        }
        return false;

    }
    //Buscar lead existente
    public LeadDTO encontrarLeadCadastrado(String email){
        for (LeadDTO leadReferencia : leadsList){
            if (leadReferencia.getEmail().equals(email)){
                return leadReferencia;

            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //verificar produto repetido
    public void verificarProdutoRepetido( LeadDTO novoLead){
        LeadDTO leadAntigo = encontrarLeadCadastrado(novoLead.getEmail());
        for (ProdutoDTO produtoAntigoReferencia : leadAntigo.getProdutos()){
            for (ProdutoDTO produtoNovoReferencia : novoLead.getProdutos()){
                if (produtoAntigoReferencia.equals(produtoNovoReferencia)){
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
                }
            }
        }
    }

    //Adicionar produto a lista existente
    public void atualizarProdutosLead(LeadDTO novoLead){
        LeadDTO leadAntiga = encontrarLeadCadastrado(novoLead.getEmail());
        for (ProdutoDTO produtoReferencia : novoLead.getProdutos()){
            leadAntiga.getProdutos().add(produtoReferencia);
        }
    }
}