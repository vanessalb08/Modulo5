package br.com.zup.investimentos.investimento;

import br.com.zup.investimentos.dtos.InvestimentoDTO;
import br.com.zup.investimentos.dtos.MontanteDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {
    private List<InvestimentoDTO> investimentos = new ArrayList<>();
    private List<MontanteDTO> montantes  =new ArrayList<>();

    public void salvarInvestimento (InvestimentoDTO novoInvestimento){
        investimentos.add(novoInvestimento);
    }

    public List<InvestimentoDTO> retornarInvestimentos(){
        return investimentos;
    }

}
