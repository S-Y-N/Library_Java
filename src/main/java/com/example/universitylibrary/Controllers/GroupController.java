package com.example.universitylibrary.Controllers;

import com.example.universitylibrary.domain.dao.IDepartmentRepository;
import com.example.universitylibrary.domain.dao.IGroupRepository;
import com.example.universitylibrary.domain.models.Departament;
import com.example.universitylibrary.domain.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class GroupController {

    @Autowired
    private IGroupRepository _group;
    @Autowired
    private IDepartmentRepository _depart;

    @GetMapping("/group")
    public String listGroup(Model model)
    {
        List<Group> groups = _group.showGroup();
        List<String> departments = _group.getDeparts();
        model.addAttribute("groups",groups);
        model.addAttribute("departments",departments);
        return "group/index";
    }
    @GetMapping("/group/create")
    public String getGroup(Model model){
        List<Departament> departments = _depart.showDepartments();
        model.addAttribute("departments",departments);
        return "group/create";
    }
    @PostMapping("/group/create")
    public ModelAndView postGroup(String name, int depart_id){
        try{
            Group group = new Group();
            group.setName(name);
            group.setDepartament(new Departament(depart_id));
            _group.save(group);
            return new ModelAndView("group/index");
        }catch (Exception ex){
            return new ModelAndView("group/index");
        }
    }
}
