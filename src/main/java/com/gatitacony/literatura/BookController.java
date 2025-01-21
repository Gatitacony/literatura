package com.gatitacony.literatura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Endpoint para listar libros por título
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    // Endpoint para listar libros por idioma
    @GetMapping("/language")
    public List<Book> getBooksByLanguage(@RequestParam String language) {
        return bookRepository.findByLanguage(language);
    }

    // Endpoint para listar todos los libros
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Endpoint para agregar un nuevo libro
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}
