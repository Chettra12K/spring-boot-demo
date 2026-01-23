package com.kun.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World! សួរស្តី Kun សូមស្វាគមន៏មកកាន់ Spring Boot";
    }
    //bonus: API មួយទៀត
    @GetMapping("/api/greeting")
    public String greeting(){
        return "សួស្តី! នេះជា Rest API ដំបូងរបស់អ្នកនៅឆ្នាំ 2027";
    }
    @GetMapping("/api/time")
    public String GetCurrentTime(){
        return "ម៉ោងបច្ចុបន្នៈ "+java.time.LocalDateTime.now();
    }
    @GetMapping("/api/name/{name}")
    public String sayHi(@PathVariable String name){
        return "សួស្តី " + name + "! រីករាយណាស់ដែលបានជួបអ្នក";
    }
}
