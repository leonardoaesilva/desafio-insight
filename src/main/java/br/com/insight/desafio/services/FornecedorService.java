package br.com.insight.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.insight.desafio.models.FornecedorModel;
import br.com.insight.desafio.repositories.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fr;

    public Iterable<FornecedorModel> listarTodos() {
        return fr.findAll();
    }

    public ResponseEntity<?> cadastrarFornecedor(FornecedorModel fornecedorNovo) {
        if (fornecedorNovo.getCnpj().equals("")) {
            String resp = "CNPJ não pode ficar em branco.";
            return new ResponseEntity<String>(resp, HttpStatus.BAD_REQUEST);
        } else if (fornecedorNovo.getNomeFantasia().equals("")) {
            String resp = "Nome Fantasia não pode ficar em branco.";
            return new ResponseEntity<String>(resp, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<FornecedorModel>(fr.save(fornecedorNovo), HttpStatus.CREATED);
    }
}
