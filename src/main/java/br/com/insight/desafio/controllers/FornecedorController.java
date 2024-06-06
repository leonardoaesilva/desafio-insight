package br.com.insight.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.insight.desafio.models.FornecedorModel;
import br.com.insight.desafio.services.FornecedorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/")
    public Iterable<FornecedorModel> listar() {
        return fornecedorService.listarTodos();
    }

    @PostMapping("/create")
    public ResponseEntity<?> cadastrar(@RequestBody FornecedorModel novoFornecedor) {
        return fornecedorService.cadastrarFornecedor(novoFornecedor);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> remover(@PathVariable(value = "id") Long id) {
        return fornecedorService.removerFornecedor(id);
    }
    
}
