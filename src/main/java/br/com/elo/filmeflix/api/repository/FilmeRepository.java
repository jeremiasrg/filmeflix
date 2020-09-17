package br.com.elo.filmeflix.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.elo.filmeflix.api.model.Filme;

public interface FilmeRepository extends MongoRepository<Filme, Integer> {

}
