package com.example.universitylibrary.Controllers;

import com.example.universitylibrary.domain.dao.IDepartmentRepository;
import com.example.universitylibrary.domain.models.Departament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class DepartamentController {
     @Autowired
     private IDepartmentRepository _depart;

    @GetMapping("/deps")
    public String listDepartaments(Model model){
        List<Departament> departments = _depart.showDepartments();
        model.addAttribute("departments",departments);
        return "department/index";
    }
    @GetMapping("/deps/create")
    public String getDeparts(Model model){
        List<Departament> departments = _depart.showDepartments();
        model.addAttribute("departments",departments);
        return "department/create";
    }
    @PostMapping("/deps/create")
    public ModelAndView postDeparts(String name){
        try{
            Departament departament  = new Departament();
            departament.setName(name);
            _depart.save(departament);
            return new ModelAndView("department/index");
        }catch (Exception ex){
            return new ModelAndView("department/error");
        }
    }
}
