package com.dev.web;

import com.dev.dao.TestClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class DeleteHeadController {

    @Autowired
    TestClasses testClasses;

    @RequestMapping(value = "dhead", method = RequestMethod.GET)
    String delById(){
        return "dhead";
    }

    @RequestMapping(value = "dhead", method = RequestMethod.POST)
    void delMetById(@ModelAttribute ("id") String id){
        System.out.println("id " + id);
        int numId = Integer.parseInt(id);
        testClasses.delById(numId);
    }

}
