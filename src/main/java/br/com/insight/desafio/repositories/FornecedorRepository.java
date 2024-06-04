package br.com.insight.desafio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.insight.desafio.models.FornecedorModel;

@Repository
public interface FornecedorRepository extends CrudRepository<FornecedorModel, Long>{
    
}
