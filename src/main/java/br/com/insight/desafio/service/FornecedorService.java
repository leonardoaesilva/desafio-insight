package br.com.insight.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.insight.desafio.model.FornecedorModel;
import br.com.insight.desafio.repository.FornecedorRepository;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fr;

    public Iterable<FornecedorModel> listarTodos() {
        return fr.findAll();
    }
}
