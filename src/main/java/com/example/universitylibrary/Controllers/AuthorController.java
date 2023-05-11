package com.example.universitylibrary.Controllers;

import com.example.universitylibrary.domain.dao.IAuthorRepository;
import com.example.universitylibrary.domain.dao.IBookRepository;
import com.example.universitylibrary.domain.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
    @Autowired
    private IAuthorRepository _author;


    @GetMapping("/author")
    public String listAuthors(Model model){
        model.addAttribute("authors", _author.findAll());
        return "author/author";
    }
    @GetMapping("/author/create")
    public String getCreate(){return "author/create";}

    @PostMapping("/author/create")
    public ModelAndView postCreate(String firstName, String lastName){
        try{
            Author author = new Author();
            author.setFirstName(firstName);
            author.setLastName(lastName);
            _author.save(author);
            return new ModelAndView("library/index");
        }catch (Exception ex){
            return new ModelAndView("library/error");
        }
    }
}
