package es.deloitte.devcontainer.java.example1.controller;

import org.springframework.web.bind.annotation.RestController;

import es.deloitte.devcontainer.java.example1.exception.BookNotExistsException;
import es.deloitte.devcontainer.java.example1.model.Book;
import es.deloitte.devcontainer.java.example1.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path = "/api/v1/book")
public class BookController {
    
    @Autowired
    private BookService service;

    @GetMapping("/")
    public List<Book> allBooks() {
        return service.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        try {
            return new ResponseEntity<>(service.findById(isbn), HttpStatusCode.valueOf(200));
        } catch (BookNotExistsException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
    }
    
    
}