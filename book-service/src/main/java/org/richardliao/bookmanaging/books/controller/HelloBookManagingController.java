package org.richardliao.bookmanaging.books.controller;

import java.util.List;
import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/library")
public class HelloBookManagingController {

    @RequestMapping(value="/books", method=GET, produces="application/json")
    public List<String> bookList() {
	ArrayList<String> res = new ArrayList<>();
	res.add("Book1");
	res.add("Book2");
	res.add("Book3");
	return res;
    }

    @RequestMapping(value="/book/{id}", method=GET, produces="application/json")
    public String bookDetail(@PathVariable("id") String id) {
	return "Detail of book [" + id + "]";
    }
}
