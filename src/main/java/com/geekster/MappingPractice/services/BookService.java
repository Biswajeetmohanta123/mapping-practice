package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.exception.ResourceNotFoundException;
import com.geekster.MappingPractice.models.Book;
import com.geekster.MappingPractice.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(String id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(String id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exist"));
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setPrice(book.getPrice());
        existingBook.setStudent(book.getStudent());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(String id) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        bookRepository.delete(existingBook);
    }
}
