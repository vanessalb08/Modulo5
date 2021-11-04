package br.com.zup.investimentos.investimento;

import br.com.zup.investimentos.dtos.InvestimentoDTO;
import br.com.zup.investimentos.dtos.MontanteDTO;
import br.com.zup.investimentos.dtos.Risco;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {

    //private List<InvestimentoDTO> investimentos = new ArrayList<>();
    private List<MontanteDTO> montantes =new ArrayList<>();

    public MontanteDTO retornarMontante(InvestimentoDTO novoInvestimento){

        MontanteDTO retornoMontante = new MontanteDTO();

        retornoMontante.setValorInvestido(novoInvestimento.getValorInvestido());
        retornoMontante.setValorTotalDolucro(calcularTotalDoLucro(novoInvestimento));
        retornoMontante.setValorTotal(calcularValorTotal(novoInvestimento));

        return retornoMontante;

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

    public double calcularTotalDoLucro (InvestimentoDTO investimentoDTO){

        double valorInvestido = investimentoDTO.getValorInvestido();
        double valorTotalLucro = valorInvestido * pegarTaxa(investimentoDTO);

        return valorTotalLucro;

    }

    public double calcularValorTotal (InvestimentoDTO investimentoDTO){

        double valorTotal = calcularTotalDoLucro(investimentoDTO) + investimentoDTO.getValorInvestido();

        return valorTotal;
    }

}