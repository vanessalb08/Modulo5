package com.example.ZupCar.controllers;

import com.example.ZupCar.dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/carros")

public class CarroController {
    private List <CarroDTO> concessionaria = new ArrayList<>();

    @GetMapping
    public List<CarroDTO> exibirTodosOsCarros(){
        return concessionaria;
    }

    //Se para colocar a resposta do método no corpo da resposta utiliza @ResponseBody (resposta do corpo), para mudar o status da resposta
    // coloca @ResponseStatus (resposta do status)
    //Só vai responder esse status quando o método for executado sem nenhum problema
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO){
        concessionaria.add(carroDTO);
    }

    //Recebe da uri e entrega para o parâmetro do método através da PathVariable)
    //Esse método lê o que foi inserido na uri e pesquisa se existe algum modelo com o nome que foi digitado na URI
    //Quando tem um /{} quer dizer que o que está dentro das {} é uma variável que vai ser atribuida depois ao parâmetro
    // através do @PathVariable
    //O verbo PATH serve para alterar parcialmente o recurso
    @GetMapping ("/{nomeDoCarro}")
    public CarroDTO exibirCarro (@PathVariable String nomeDoCarro){
        for (CarroDTO carro : concessionaria){
            if (carro.getModelo().equalsIgnoreCase(nomeDoCarro)){
                return carro;
            }
        }
        //Estoura uma exceção para dizer que o nome não foi encontrado, assim não retorna null
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    //Alterar o nome do carro
    @PutMapping("/{nomeDoCarro")
    public CarroDTO atualizarCarro(@PathVariable String nomeDoCarro){
        for (CarroDTO carroReferencia : concessionaria){
            if (carroReferencia.getModelo().equalsIgnoreCase(nomeDoCarro)){
                return carroReferencia;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
