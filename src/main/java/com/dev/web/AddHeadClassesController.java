package com.dev.web;


import com.dev.domain.Classes;
import com.dev.domain.DoubleClass;
import com.dev.domain.Head;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddHeadClassesController {

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    String getForm(Model model){


        Head head = new Head();
        head.setName("");

        model.addAttribute("doubleClass", new DoubleClass());
//        model.addAttribute("head", head);
//        model.addAttribute("classes", new Classes());

        return "save";
    }



    @RequestMapping(value = "/form", method = RequestMethod.POST)
    String addInDB (@ModelAttribute("doubleClass")DoubleClass doubleClass){



        System.out.println("head = [" + doubleClass.getHead().getName() + "], classes = [" + doubleClass.getClasses().getHead().getName() + "]");
        return "index";
    }

}
