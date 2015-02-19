package com.dev.web;

import com.dev.dao.TestClasses;
import com.dev.domain.Classes;
import com.dev.domain.Head;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    TestClasses testClasses;

    @RequestMapping("/s")
    String met (Model model){

        Head h = testClasses.getHead();

        System.out.println(h.getName());
        for (Classes classes : h.getClasses()) {
            System.out.println(classes.getName());
        }

        List<Head> resultHeads = new ArrayList<Head>();
        resultHeads.add(h);
        Set<Classes> resultClasseses = h.getClasses();
        model.addAttribute("heads", resultHeads);
        model.addAttribute("class", resultClasseses);
        return "index";
    }

}
