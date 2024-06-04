package br.com.insight.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.insight.desafio.model.FornecedorModel;

@Repository
public interface FornecedorRepository extends CrudRepository<FornecedorModel, Long>{
    
}
