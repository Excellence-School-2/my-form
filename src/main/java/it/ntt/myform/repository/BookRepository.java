package it.ntt.myform.repository;

import org.springframework.data.repository.CrudRepository;

import it.ntt.myform.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    
}
