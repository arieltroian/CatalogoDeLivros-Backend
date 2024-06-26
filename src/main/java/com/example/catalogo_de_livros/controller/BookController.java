package com.example.catalogo_de_livros.controller;

import com.example.catalogo_de_livros.book.Book;
import com.example.catalogo_de_livros.book.BookRepository;
import com.example.catalogo_de_livros.book.BookRequestDTO;
import com.example.catalogo_de_livros.book.BookResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveBook(@RequestBody BookRequestDTO data){
        Book bookData = new Book(data);
        repository.save(bookData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<BookResponseDTO> getAll(){

        List<BookResponseDTO> bookList = repository.findAll().stream().map(BookResponseDTO::new).toList();
        return bookList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookRequestDTO data){
        Book bookData = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        bookData.updateFromDTO(data);
        repository.save(bookData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        repository.deleteById(id);
        return;
    }
}
