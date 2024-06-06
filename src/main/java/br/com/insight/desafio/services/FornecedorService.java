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

    public ResponseEntity<Object> cadastrarFornecedor(FornecedorModel novoFornecedor) {
        if (novoFornecedor.getCnpj().equals("")) {
            String resp = "CNPJ é um campo de preenchimento obrigatório.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        } else if (novoFornecedor.getRazaoSocial().equals("")) {
            String resp = "Nome/Razão Social é um campo de preenchimento obrigatório.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorRepository.save(novoFornecedor));
    }
    
    public ResponseEntity<Object> listarUm(Long codigoFornecedor) {
        Optional<FornecedorModel> f = fornecedorRepository.findById(codigoFornecedor);
        String resp = "";

        if (f.isEmpty()) {
            resp = "Fornecedor não encontrado. Verifique o código informado e tente novamente.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }

        return ResponseEntity.status(HttpStatus.OK).body(f.get());
    }

    public ResponseEntity<Object> atualizarDadosFornecedor(Long codigoFornecedor, FornecedorModel fornecedor) {
        Optional<FornecedorModel> f = fornecedorRepository.findById(codigoFornecedor);
        String resp = "";

        if (f.isEmpty()) {
            resp = "Fornecedor não encontrado. Verifique o código informado e tente novamente.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }

        fornecedor = f.get();

        return ResponseEntity.status(HttpStatus.OK).body(fornecedorRepository.save(fornecedor));
    }

    public ResponseEntity<String> removerFornecedor(Long codigoFornecedor) {
        Optional<FornecedorModel> f = fornecedorRepository.findById(codigoFornecedor);
        String resp = "";

        if (f.isEmpty()) {
            resp = "Fornecedor não encontrado. Verifique o código informado e tente novamente.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
        }

        fornecedorRepository.deleteById(codigoFornecedor);
        resp = "Fornecedor excluído com sucesso!";

        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }
}
