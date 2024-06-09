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
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/fornecedores")
    public Iterable<FornecedorModel> listar() {
        return fornecedorService.listarTodos();
    }

    @PostMapping("/create")
    public ResponseEntity<Object> cadastrar(@RequestBody FornecedorModel novoFornecedor) {
        return fornecedorService.cadastrarFornecedor(novoFornecedor);
    }

    @GetMapping("/read/{codigoFornecedor}")
    public ResponseEntity<Object> buscar(@PathVariable(value = "codigoFornecedor") Long codigoFornecedor) {
        return fornecedorService.listarUm(codigoFornecedor);
    }

    @PutMapping("/update/{codigoFornecedor}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "codigoFornecedor") Long codigoFornecedor, @RequestBody FornecedorModel fornecedor) {
        return fornecedorService.atualizarDadosFornecedor(codigoFornecedor, fornecedor);
    }

    @DeleteMapping("/delete/{codigoFornecedor}")
    public ResponseEntity<String> remover(@PathVariable(value = "codigoFornecedor") Long codigoFornecedor) {
        return fornecedorService.removerFornecedor(codigoFornecedor);
    }
    
}
