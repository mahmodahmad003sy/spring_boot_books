package com.example.books.controller;

import com.example.books.dto.BookRequest;
import com.example.books.dto.BookResponse;
import com.example.books.entity.Book;
import com.example.books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll() {
        List<BookResponse> out = service.findAll()
                .stream()
                .map(b -> new BookResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getYear(), b.getDescription()))
                .toList();
        return ResponseEntity.ok(out); // 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(@PathVariable Long id) {
        Book b = service.findById(id);
        return ResponseEntity.ok(new BookResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getYear(), b.getDescription())); // 200
    }

    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest req, UriComponentsBuilder uri) {
        Book b = service.create(req);
        var location = uri.path("/api/books/{id}").buildAndExpand(b.getId()).toUri();
        return ResponseEntity.created(location)
                .body(new BookResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getYear(), b.getDescription())); // 201
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> update(@PathVariable Long id, @Valid @RequestBody BookRequest req) {
        Book b = service.update(id, req);
        return ResponseEntity.ok(new BookResponse(b.getId(), b.getTitle(), b.getAuthor(), b.getYear(), b.getDescription())); // 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }
}
