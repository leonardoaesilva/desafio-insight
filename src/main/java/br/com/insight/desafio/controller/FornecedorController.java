package br.com.insight.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.insight.desafio.model.FornecedorModel;
import br.com.insight.desafio.service.FornecedorService;

@RestController
public class FornecedorController {
    @Autowired
    private FornecedorService fs;

    @GetMapping("/")
    public Iterable<FornecedorModel> listar() {
        return fs.listarTodos();
    }
}
