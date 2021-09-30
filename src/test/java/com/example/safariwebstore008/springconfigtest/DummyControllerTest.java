package com.example.safariwebstore008.springconfigtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DummyControllerTest {
    @RequestMapping(path = "/**", method = RequestMethod.GET)
    @ResponseBody
    public String catchAll() {
        return "DummyCatchallController#catchAll";
    }

    @GetMapping("/greeting")
    @ResponseBody
    public String greet(){
        return "Hello world";
    }

}
