package br.com.insight.desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
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
}
