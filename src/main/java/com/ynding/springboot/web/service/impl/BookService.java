package com.ynding.springboot.web.service.impl;

import com.ynding.springboot.entity.Book;
import com.ynding.springboot.web.data.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByReader(String reader) {

        return bookRepository.findByReader(reader);
    }

    public Book Save(Book book){
        return bookRepository.save(book);
    }
}
