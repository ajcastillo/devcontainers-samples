package es.deloitte.devcontainer.java.example1.service;

import java.util.List;

import es.deloitte.devcontainer.java.example1.exception.BookNotExistsException;
import es.deloitte.devcontainer.java.example1.model.Book;

public interface BookService {
    
    public List<Book> findAll();

    public Book findById(String isbn) throws BookNotExistsException;
}