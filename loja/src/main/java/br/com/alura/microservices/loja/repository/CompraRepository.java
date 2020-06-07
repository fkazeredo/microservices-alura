package br.com.alura.microservices.loja.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservices.loja.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long>{

}
