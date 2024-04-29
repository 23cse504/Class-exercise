package com.example.q1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.kesavAuthor;
import com.example.q1.model.kesavBook;
import com.example.q1.repository.kesavAuthorRepository;
import com.example.q1.repository.kesavBookRepository;

@Service
public class kesavBookService {
    @Autowired
    private kesavBookRepository bookRepository;
@Autowired
private kesavAuthorRepository authorRepository;
    public kesavBook saveBook(Long authorId, kesavBook book) {
        kesavAuthor author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            book.setAuthor(author);
            author.getBooks().add(book);
            return bookRepository.save(book);
        }
        return null;
    }

    public kesavBook getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

