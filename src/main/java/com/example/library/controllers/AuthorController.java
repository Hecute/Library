package com.example.library.controllers;

import com.example.library.model.Author;
import com.example.library.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorService) {
        this.authorRepository = authorService;
    }


    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author selectAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }
}
