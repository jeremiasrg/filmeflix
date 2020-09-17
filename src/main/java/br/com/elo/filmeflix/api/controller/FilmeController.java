package br.com.elo.filmeflix.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.elo.filmeflix.api.error.BadRequestException;
import br.com.elo.filmeflix.api.error.ResourceNotFoundException;
import br.com.elo.filmeflix.api.model.Filme;
import br.com.elo.filmeflix.api.repository.FilmeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Filme")
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @ApiOperation(value = "Adiciona um novo filme")
    @PostMapping("/add")
    public ResponseEntity<?> saveFilme(@RequestBody Filme filme) {

        try {
            repository.save(filme);
            return new ResponseEntity<>("Filme criado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Nao foi possivel criar o filme.", HttpStatus.BAD_REQUEST);
        }

    }

    @ApiOperation(value = "Lista todos os filmes")
    @GetMapping("/findAll")
    public List<Filme> getFilmes() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new BadRequestException("Filme nao encontrado");
        }

    }

    @ApiOperation(value = "Busca um filme por id")
    @GetMapping("find/{id}")
    public Optional<Filme> getFilme(@PathVariable int id) {
        Optional<Filme> rt = repository.findById(id);
        if (!rt.isPresent()) {
            throw new ResourceNotFoundException("Filme nao encontrado");
        } else {
            return rt;
        }
    }

    @ApiOperation(value = "Remove filme")
    @DeleteMapping("/delete/{id}")
    public void deleteFilme(@PathVariable int id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new BadRequestException("Filme nao encontrado");
        }

    }

}
