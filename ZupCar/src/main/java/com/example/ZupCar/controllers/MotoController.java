package com.example.ZupCar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/motos")
public class MotoController {
    @GetMapping("/vespa")
    public HashMap<String, String> exibirVespa(){
        HashMap <String, String> vespa = new HashMap<>();
        vespa.put("Moto", "vermelha");
        vespa.put("Ano", "1984");
        vespa.put("Motor", "mil");

        return vespa;
    }
    @GetMapping("/bis")
    public HashMap<String, String> exibirBis(){
        HashMap <String, String> bis = new HashMap<>();
        bis.put("Moto", "branco");
        bis.put("Ano", "1999");
        bis.put("Motor", "dois");

        return bis;
    }
}
