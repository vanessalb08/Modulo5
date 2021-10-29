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
        for (LeadDTO leadReferencia : leadsList) {
            if (leadReferencia.getEmail().equals(novoLead.getEmail())) {
                for (ProdutoDTO produtoReferencia : leadReferencia.getProdutos()){
                    //Corrigir isso aqui que não tá funcionando
                    if (produtoReferencia.getNomeProduto().equals(novoLead.getProdutos())){
                        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
                    }
                    leadReferencia.getProdutos().add(produtoReferencia);
                }
            }
        }
        leadsList.add(novoLead);
    }

}