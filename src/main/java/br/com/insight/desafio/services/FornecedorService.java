package br.com.insight.desafio.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.insight.desafio.models.FornecedorModel;
import br.com.insight.desafio.repositories.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Iterable<FornecedorModel> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public ResponseEntity<Object> cadastrarFornecedor(FornecedorModel fornecedorNovo) {
        if (fornecedorNovo.getCnpj().equals("")) {
            String resp = "CNPJ não pode ficar em branco.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        } else if (fornecedorNovo.getRazaoSocial().equals("")) {
            String resp = "Nome Fantasia não pode ficar em branco.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(fornecedorNovo));
    }

    public ResponseEntity<String> removerFornecedor(Long codigoInterno) {
        String resp = "";
        Optional<FornecedorModel> f = fornecedorRepository.findById(codigoInterno);

        if (f.isEmpty()) {
            resp = "Fornecedor não encontrado! Verifique o código novamente.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }

        fornecedorRepository.deleteById(codigoInterno);
        resp = "Fornecedor excluído com sucesso!";
        
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
