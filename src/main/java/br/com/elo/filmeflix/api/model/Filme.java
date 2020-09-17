package br.com.elo.filmeflix.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "filme")
public class Filme {

    @Id
    private int id;
    private String titulo;
    // Outros atributos relevantes

}
