package br.com.insight.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.insight.desafio.models.FornecedorModel;
import br.com.insight.desafio.services.FornecedorService;

@RestController
public class FornecedorController {
    @Autowired
    private FornecedorService fs;

    @GetMapping("/")
    public Iterable<FornecedorModel> listar() {
        return fs.listarTodos();
    }
}
