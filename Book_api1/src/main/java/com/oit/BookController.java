package com.oit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

   
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle()); // Use updatedBook.getTitle() directly
                    book.setAuthor(updatedBook.getAuthor()); // Use updatedBook.getAuthor() directly
                    return bookRepository.save(book);
                })
                .orElseGet(() -> {
                    updatedBook.setId(id); // Use updatedBook.setId(id) directly
                    return bookRepository.save(updatedBook);
                });
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
