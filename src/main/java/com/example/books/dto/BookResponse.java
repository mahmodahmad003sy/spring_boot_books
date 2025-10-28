package com.example.books.dto;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private String description;

    public BookResponse(Long id, String title, String author, Integer year, String description) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public Integer getYear() { return year; }
    public String getDescription() { return description; }
}
