package it.ntt.myform.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import it.ntt.myform.model.Book;


@Service
public class BookListService {
    private List<Book> books = new ArrayList<>(Arrays.asList(
            new Book(1L, "titolo1", "autore1"), 
            new Book(2L, "titolo2", "autore2"),
            new Book(3L, "titolo3", "autore3")
        ));

    public List<Book> getAllBooks(){
        return books;
    }

    public Book getBook(Long id){
        return books.stream()
                    .filter(b -> b.getId() == id)
                    .findFirst()
                    .get();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void deleteBookById(Long id){
        books.removeIf(b -> b.getId()==id);
    }

}
