package vn.codegym.borrowbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.borrowbook.model.Book;
import vn.codegym.borrowbook.service.BookService;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping(value = "/show")
    public ModelAndView showListBook(){
        Iterable<Book> books = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books",books);
        return modelAndView;
    }

    @GetMapping(value = "/add-book")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book",new Book());
        return modelAndView;
    }
}
