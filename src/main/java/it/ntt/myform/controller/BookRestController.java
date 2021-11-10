package it.ntt.myform.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.ntt.myform.model.Book;
import it.ntt.myform.repository.BookRepository;
import it.ntt.myform.service.BookListService;

@RestController
public class BookRestController {

    private final BookListService bookListService;
    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository, BookListService bookListService){
        this.bookListService = bookListService;
        this.bookRepository = bookRepository;
    }
    
    @GetMapping("/api/books")
    public List<Book> getBooks(){
        return bookListService.getAllBooks();
    }

    @GetMapping("/api/v2/books")
    public List<Book> getBooksFromH2(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @GetMapping("/api/books/{id}")
    public Book getBook(@PathVariable Long id){
        return bookListService.getBook(id);
    }

    @PostMapping("/api/books")
    public void addBook(@RequestBody Book book){
        bookListService.addBook(book);
    }

    @DeleteMapping("/api/books/{id}")
    public void deleteBook(@PathVariable Long id){
        bookListService.deleteBookById(id);
    }
}
