package org.zerock.topik.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class baseController {

    @GetMapping("topik/page")
    public String page() {
        return "topik/page";

    }

}
