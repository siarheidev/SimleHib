package com.dev.web;

import com.dev.domain.AjaxDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class TestAjaxController {


    @RequestMapping(value = "ajax", method = RequestMethod.GET)
    String page (){
        return "aindex";
    }

    @RequestMapping(value = "ajaxtest", method = RequestMethod.POST)
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