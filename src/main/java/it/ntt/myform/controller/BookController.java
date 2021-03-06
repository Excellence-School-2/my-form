package it.ntt.myform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.ntt.myform.model.Book;
import it.ntt.myform.repository.BookRepository;


@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //@RequestMapping(value ="/books", method=RequestMethod.GET)
    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    //@RequestMapping(value ="/addbook", method=RequestMethod.POST)
    @PostMapping("/addbook")
    //public String addBook(String title, String author){
    public String addBook(Book book){
        //Book book = new Book(title, author);
        bookRepository.save(book);
        return "redirect:/books";
    }

    //@RequestMapping(value ="/deleteBook/{id}", method=RequestMethod.POST)
    @PostMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id){
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
    
    
}
