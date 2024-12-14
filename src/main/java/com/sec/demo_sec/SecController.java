package com.sec.demo_sec;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecController {

    @GetMapping("/demo")
    public String demo(){
        return "You are here!!";
    }

    @GetMapping("/testcode")
    public String testcode(){
        return "You are in Test!!";
    }

    @GetMapping("/devcode")
    public String devcode(){
        return "You are in Dev!!";
    }

    @GetMapping("/home")
    public String home(){
        return "You are in home!!";
    }

    @GetMapping("/accessserver")
    public String accessserver(){
        return "You are in accessserver!!";
    }
}
