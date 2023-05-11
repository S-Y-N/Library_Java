package com.example.universitylibrary.Controllers;

import com.example.universitylibrary.domain.dao.IAuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView Index(){
      return new ModelAndView("home/index", "data", new Object());
  }

}

