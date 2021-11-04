package br.com.zup.investimentos.investimento;

import br.com.zup.investimentos.dtos.InvestimentoDTO;
import br.com.zup.investimentos.dtos.MontanteDTO;
import br.com.zup.investimentos.dtos.Risco;
import br.com.zup.investimentos.investimento.exceptions.InvestimentoAltoRiscoMenorQueCincoMilException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvestimentoService {

    //private List<InvestimentoDTO> investimentos = new ArrayList<>();
    private List<MontanteDTO> montantes =new ArrayList<>();

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

    public double calcularValorTotal(InvestimentoDTO investimentoDTO){

        double valorInvestido = investimentoDTO.getValorInvestido();
        int meses = investimentoDTO.getPeriodoDeAplicacaoMeses();

        double valorTotal = valorInvestido * Math.pow(1 + pegarTaxa(investimentoDTO), meses);

        return valorTotal;

    }

    public double calcularValorTotalLucro(InvestimentoDTO investimentoDTO){

        double valorTotalLucro = calcularValorTotal(investimentoDTO) - investimentoDTO.getValorInvestido();

        return valorTotalLucro;
    }

    public MontanteDTO retornarMontante(InvestimentoDTO novoInvestimento){

        MontanteDTO retornoMontante = new MontanteDTO();

        validarAltoRisco(novoInvestimento);

        retornoMontante.setValorInvestido(novoInvestimento.getValorInvestido());
        retornoMontante.setValorTotalDolucro(calcularValorTotalLucro(novoInvestimento));
        retornoMontante.setValorTotal(calcularValorTotal(novoInvestimento));

        montantes.add(retornoMontante);

        return retornoMontante;

    }

    public List<MontanteDTO> retornarTodosMontantes(){
        return montantes;
    }

    public void validarAltoRisco(InvestimentoDTO investimentoDTO){

        double investimentoMinimo = 5000;

        if (investimentoDTO.getRisco() == Risco.ALTO & investimentoDTO.getValorInvestido() < investimentoMinimo){
            throw new InvestimentoAltoRiscoMenorQueCincoMilException("Mínimo investido para esse tipo de risco é de R$ 5000,00");
        }

    }

}