package demo.springgitexample.service;

import demo.springgitexample.model.Author;
import demo.springgitexample.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements  AuthorService {


    private AuthorRepository authorRepository;
    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findbyId(Long id) {
        return authorRepository.getOne(id);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }
}
