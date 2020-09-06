package edu.zxie0018.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/userSave")
    public String save() {
        System.out.println("UserController save running!");
        return "successSave.jsp";
    }
}
