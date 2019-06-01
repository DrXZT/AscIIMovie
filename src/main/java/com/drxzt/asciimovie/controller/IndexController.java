package com.drxzt.asciimovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * className IndexController
 * description TODO
 *
 * @author DR XZT
 * @version 1.0
 * @date 2019/6/1 15:04
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "/test.html";
    }
}
