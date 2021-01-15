package vn.codegym.borrowbook.service;

import vn.codegym.borrowbook.model.Book;

public interface BookService {
    Iterable<Book> findAll();

    Book findById(Long id);

    void save(Book book);

    void remove(Long id);
}
