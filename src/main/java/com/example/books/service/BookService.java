package com.example.books.service;

import com.example.books.dto.BookRequest;
import com.example.books.entity.Book;
import com.example.books.exception.NotFoundException;
import com.example.books.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> findAll() {
        return repo.findAll();
    }

    public Book findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Book " + id + " not found"));
    }

    public Book create(BookRequest req) {
        Book b = new Book(req.getTitle(), req.getAuthor(), req.getYear(), req.getDescription());
        return repo.save(b);
    }

    public Book update(Long id, BookRequest req) {
        Book b = findById(id);
        b.setTitle(req.getTitle());
        b.setAuthor(req.getAuthor());
        b.setYear(req.getYear());
        b.setDescription(req.getDescription());
        return repo.save(b);
    }

    public void delete(Long id) {
        Book b = findById(id);
        repo.delete(b);
    }
}
