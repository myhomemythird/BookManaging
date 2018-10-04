package org.richardliao.bookmanaging.books.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.richardliao.bookmanaging.books.domain.Book;
import org.richardliao.bookmanaging.books.mapper.BookMapper;

@RestController
@RequestMapping(value="/library", produces="application/json")
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping(value="/books", method=GET)
    public List<Book> bookList() {
        Map<String, String> query = new HashMap<>();
	return bookMapper.getBookList(query);
    }

    @RequestMapping(value="/book/{id}", method=GET)
    public Book bookDetail(@PathVariable("id") String id) {
	return bookMapper.getBookById(id);
    }

    @RequestMapping(value="/book", method=POST)
    public String addBook(@RequestBody Book book) {
	if (null == book || null == book.getId()) return "Failed. Book or Book.id is null!";
	bookMapper.add(book);
	return "succeed";
    }

    @RequestMapping(value="/book", method=PUT)
    public String updateBook(@RequestBody Book book) {
	if (null == book || null == book.getId()) return "Failed. Book or Book.id is null!";
	Book bookDb = bookMapper.getBookById(book.getId());
	if (null == bookDb) return "Failed. No Book [" + book.getId() + "] found!";
	bookMapper.update(book);
	return "succeed";
    }

    @RequestMapping(value="/book/{id}", method=DELETE)
    public String deleteBook(@PathVariable("id") String id) {
	Book bookDb = bookMapper.getBookById(id);
        if (null == bookDb) return "Failed. No Book [" + id + "] found!";
	bookMapper.delete(id);
	return "succeed";
    }
}
