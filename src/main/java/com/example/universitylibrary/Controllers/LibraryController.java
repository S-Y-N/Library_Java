package com.example.universitylibrary.Controllers;

import com.example.universitylibrary.domain.dao.IAuthorRepository;
import com.example.universitylibrary.domain.dao.IBookRepository;
import com.example.universitylibrary.domain.dao.IGenreRepository;
import com.example.universitylibrary.domain.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LibraryController {
    @Autowired
    private IBookRepository _book;

   @GetMapping("/books")
    public String getAllBooks(Model model){
       List<Book> books = _book.showAllBooks();
       List<String> genres = _book.listGenre();
       List<String> publishes = _book.getPublish();
       model.addAttribute("books",books);
       model.addAttribute("genres",genres);
       model.addAttribute("publishes",publishes);
       return "library/index";
   }
}
