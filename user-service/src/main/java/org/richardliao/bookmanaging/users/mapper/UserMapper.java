package org.richardliao.bookmanaging.books.mapper;

import java.util.List;
import java.util.Map;

import org.richardliao.bookmanaging.books.domain.Book;

public interface BookMapper {
    List<Book> getBookList(Map<String, String> query);

    Book getBookById(String id);

    int add(Book book);

    int update(Book book);

    int delete(String id);
}
