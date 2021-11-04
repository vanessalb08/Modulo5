package br.com.zup.investimentos.investimento;

import br.com.zup.investimentos.dtos.InvestimentoDTO;
import br.com.zup.investimentos.dtos.MontanteDTO;
import br.com.zup.investimentos.dtos.Risco;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {

    private List<InvestimentoDTO> investimentos = new ArrayList<>();
    private List<MontanteDTO> retornoMontantes =new ArrayList<>();

    public void retornarInvestimento(InvestimentoDTO novoInvestimento){
        investimentos.add(novoInvestimento);
    }

    public List<InvestimentoDTO> retornarInvestimentos(){
        return investimentos;
    }

    public double pegarTaxa (InvestimentoDTO investimentoDTO){
        double taxaDeRetorno = 0;
        
        if (investimentoDTO.getRisco() == Risco.ALTO){
            taxaDeRetorno = Risco.ALTO.getTaxaDeRetorno();

        }
        else if(investimentoDTO.getRisco() == Risco.MEDIO){
            taxaDeRetorno = Risco.MEDIO.getTaxaDeRetorno();

        }
        else if (investimentoDTO.getRisco() == Risco.BAIXO){
            taxaDeRetorno = Risco.BAIXO.getTaxaDeRetorno();

        }
        
        return taxaDeRetorno;

    }

    public double calcularInvestimento (InvestimentoDTO investimentoDTO){

        double valorInvestido = investimentoDTO.getValorInvestido();
        double valorTotal = valorInvestido * pegarTaxa(investimentoDTO);

        return valorTotal;

    }

}