package com.dev.web;

import com.dev.DTO.AjaxDom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class TestAjaxController {


    @RequestMapping(value = "ajax", method = RequestMethod.GET)
    String page (){
        return "aindex";
    }

    @RequestMapping(value = "ajaxtest/a", method = RequestMethod.POST)
    public @ResponseBody
    AjaxDom test (@RequestBody AjaxDom one) {

        System.out.println(one.getOne() + " - getOne");

        AjaxDom aj = new AjaxDom();
        aj.setOne("odin");
        aj.setTwo("dwa");

        String json = null;

        return aj;
    }

}