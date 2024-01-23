package es.deloitte.devcontainer.java.example1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.deloitte.devcontainer.java.example1.exception.BookNotExistsException;
import es.deloitte.devcontainer.java.example1.model.Book;
import es.deloitte.devcontainer.java.example1.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        repository.findAll().forEach(books::add);

        return books;
    }

    @Override
    public Book findById(String isbn) throws BookNotExistsException {
        Optional<Book> finded = repository.findById(isbn);

        return finded.orElseThrow(BookNotExistsException::new);
    }

}