package br.com.insight.desafio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FornecedorController {
    @GetMapping("/")
    public String resp() {
        return "Olá!";
    }
}
