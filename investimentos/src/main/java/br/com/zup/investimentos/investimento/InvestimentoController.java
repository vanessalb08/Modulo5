package br.com.zup.investimentos.investimento;

import br.com.zup.investimentos.dtos.InvestimentoDTO;
import br.com.zup.investimentos.dtos.MontanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void cadastrarInvestimento (@RequestBody @Valid InvestimentoDTO novoInvestimento){
        investimentoService.retornarMontante(novoInvestimento);
    }

    @GetMapping
    public List<MontanteDTO> exibirInvestimento (){
        return investimentoService.retornarTodosMontantes();
    }

}
