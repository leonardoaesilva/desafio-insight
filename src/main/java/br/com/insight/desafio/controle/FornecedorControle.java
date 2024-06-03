package br.com.insight.desafio.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FornecedorControle {
    @GetMapping("/")
    public String resp() {
        return "Olá!";
    }
}
