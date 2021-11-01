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
        leadsList.add(novoLead);

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

    //verificar produto repetido

    //Adicionar produto a lista existente

}