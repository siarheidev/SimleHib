package com.dev.web;

import com.dev.DTO.AjaxDom;
import com.dev.dao.TestClasses;
import com.dev.domain.Head;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestAjaxController {

    @Autowired
    TestClasses testClasses;

    @RequestMapping(value = "ajax", method = RequestMethod.GET)
    String page (){
        return "aindex";
    }

    @RequestMapping(value = "ajaxtest", method = RequestMethod.POST)
    public @ResponseBody
    Head test (@RequestBody AjaxDom one) {

        System.out.println(one.getOne() + " - getOne");
        System.out.println(one.getTwo() + " - getTwo");

        int id = Integer.parseInt(one.getOne());
        Head head = testClasses.getHeadlById(id);

        AjaxDom aj = new AjaxDom();
        aj.setOne("odin");
        aj.setTwo("dwa");

        String json = null;

        return head;
    }

}