package com.example.ZupCar.controllers;

import com.example.ZupCar.dtos.CarroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

//Primeira coisa é identificar a classe como controller

//@Controller
@RestController // Ele insere automaticamente o responseBody em todos os métodos
@RequestMapping("/carros") //Mapeia o /carro para todos os métodos, eviatando a repetição no getMapping.
//Como se estivesse concatenando os endpoints
public class CarroController {
    //Esse é o endpoint
    @GetMapping("/fusca")//O que tem nos parênteses depois da / é o endereço específico de acesso
    //Manda o
   // @ResponseBody //Colocar o retorno da resposta no corpo. Informa que o retorno dele será serializado
    // (no nosso caso, um JASON)
    public CarroDTO exibirFusca(){
        CarroDTO fusca = new CarroDTO("fusca"," azul", "mil", 1987);
        return fusca;
    }
    @GetMapping("/kombi")
    public CarroDTO exibirKombi(){
        CarroDTO kombi = new CarroDTO("kombi"," branca", "mil", 1962);
        return kombi;
    }
}
