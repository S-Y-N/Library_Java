package com.example.universitylibrary.Controllers;

import com.example.universitylibrary.domain.dao.ITeacherRepository;
import com.example.universitylibrary.domain.models.Departament;
import com.example.universitylibrary.domain.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private ITeacherRepository _teacher;

    @GetMapping("/teacher")
    public String listTeacher(Model model){
    List<Teacher> teachers = _teacher.showTeachers();
    List<String> departments = _teacher.getDeparts();

    model.addAttribute("teachers",teachers);
    model.addAttribute("departments",departments);
    return "teacher/index";
    }

    @GetMapping("/teacher/create")
    public String getTeacher(Model model){
        List<Teacher> teachers = _teacher.showTeachers();
        model.addAttribute("teachers",teachers);
        return "teacher/create";}

    @PostMapping("/teacher/create")
    public ModelAndView postTeacher(String firstName, String lastName, int depart_id){
        try{
            Teacher teacher = new Teacher();
            teacher.setFirstName(firstName);
            teacher.setLastName(lastName);
            teacher.setDepartament(new Departament(depart_id));
            _teacher.save(teacher);
            return  new ModelAndView("teacher/index");
        }catch (Exception ex){
            return new ModelAndView("teacher/error");
        }
    }
}
