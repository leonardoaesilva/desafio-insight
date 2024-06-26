package br.com.insight.desafio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:3000")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping("/api/fornecedores")
    public Iterable<FornecedorModel> listar() {
        return fornecedorService.listarTodos();
    }

    @PostMapping("/api/create")
    public ResponseEntity<Object> cadastrar(@RequestBody FornecedorModel novoFornecedor) {
        return fornecedorService.cadastrarFornecedor(novoFornecedor);
    }

    @GetMapping("/api/read/{codigoFornecedor}")
    public ResponseEntity<Object> buscar(@PathVariable(value = "codigoFornecedor") Long codigoFornecedor) {
        return fornecedorService.listarUm(codigoFornecedor);
    }

    @PutMapping("/api/update/{codigoFornecedor}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "codigoFornecedor") Long codigoFornecedor, @RequestBody FornecedorModel fornecedor) {
        return fornecedorService.atualizarDadosFornecedor(codigoFornecedor, fornecedor);
    }

    @DeleteMapping("/api/delete/{codigoFornecedor}")
    public ResponseEntity<String> remover(@PathVariable(value = "codigoFornecedor") Long codigoFornecedor) {
        return fornecedorService.removerFornecedor(codigoFornecedor);
    }
    
}
