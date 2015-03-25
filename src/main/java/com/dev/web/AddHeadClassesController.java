package com.dev.web;


import com.dev.dao.TestClasses;
import com.dev.domain.Classes;
import com.dev.domain.DoubleClass;
import com.dev.domain.Head;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class AddHeadClassesController {

    @Autowired
    TestClasses testClasses;
//
//    class  DoubleClass {
//        Head head;
//        Classes classes;
//
//        public Head getHead() {
//            return head;
//        }
//
//        public void setHead(Head head) {
//            this.head = head;
//        }
//
//        public Classes getClasses() {
//            return classes;
//        }
//
//        public void setClasses(Classes classes) {
//            this.classes = classes;
//        }
//
//    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    String getForm(Model model) {

        model.addAttribute("date", new String());
        model.addAttribute("doubleClass", new DoubleClass());
//        model.addAttribute("head", head);
//        model.addAttribute("classes", new Classes());

        return "save";
    }


    @RequestMapping(value = "/forma", method = RequestMethod.POST)
    String addInDB(HttpServletRequest request, @ModelAttribute("doubleClass") DoubleClass doubleClass) {


        System.out.println(doubleClass.getHead().gettDate());
        System.out.println("head = [" + doubleClass.getHead().getName() + "], classes = ["
                + doubleClass.getClasses().getName() + "]");

        String time = doubleClass.getHead().gettDate();
        DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = new Date(formatDate.parse(time).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        doubleClass.getHead().setBirthday(date);

        testClasses.saveDouble(doubleClass);

        return "index";
    }

}
