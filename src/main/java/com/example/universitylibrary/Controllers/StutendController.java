package com.example.universitylibrary.Controllers;

import com.example.universitylibrary.domain.dao.IBookRepository;
import com.example.universitylibrary.domain.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StutendController {

    @Autowired
    private IBookRepository _book;

    @GetMapping("/libs")
    public String getAllBooks(Model model){
        List<Book> books = _book.showAllBooks();
        model.addAttribute("books",books);
        return "student/book";
    }
}
