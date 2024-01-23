package es.deloitte.devcontainer.java.example1.repository;

import org.springframework.stereotype.Repository;

import es.deloitte.devcontainer.java.example1.model.Book;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {


}