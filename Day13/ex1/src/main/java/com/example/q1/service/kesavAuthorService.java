package com.example.q1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.q1.model.kesavAuthor;
import com.example.q1.repository.kesavAuthorRepository;

@Service
public class kesavAuthorService {
    @Autowired
    private kesavAuthorRepository authorRepository;

    public kesavAuthor saveAuthor(kesavAuthor author) {
        return authorRepository.save(author);
    }

    public kesavAuthor getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    public List<kesavAuthor> getAllAuthors() {
        return authorRepository.findAll();
    }

    public kesavAuthor updateAuthor(Long id, kesavAuthor author) {
        kesavAuthor existingAuthor = authorRepository.findById(id).orElse(null);
        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setPhoneNumber(author.getPhoneNumber());
            existingAuthor.setAddress(author.getAddress());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
