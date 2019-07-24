package demo.springgitexample.service;

import demo.springgitexample.model.Author;

import java.util.List;

public interface AuthorService {

    Author create(Author author);
    Author findbyId(Long id);
    List<Author> findAll();
}
