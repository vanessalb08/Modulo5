package com.example.ZupCar.controllers;

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
    public HashMap<String, String> exibirFusca(){
        //Usando o hash para fazer o JSON
        HashMap <String, String> fusca = new HashMap<>();
        fusca.put("Car", "azul");
        fusca.put("Ano", "1964");
        fusca.put("Motor", "mil");

        return fusca;
    }
    @GetMapping("/kombi")
    public HashMap<String, String> exibirKombi(){
        //Usando o hash para fazer o JSON
        HashMap <String, String> kombi = new HashMap<>();
        kombi.put("Car", "branco");
        kombi.put("Ano", "1972");
        kombi.put("Motor", "mil");

        return kombi;
    }
}
