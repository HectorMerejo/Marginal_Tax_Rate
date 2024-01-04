package com.example.merejo.marginaltaxrate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping({ "/home", "/index",  "/" })
    public String index() {
        return "index.jsp";
    }
}

