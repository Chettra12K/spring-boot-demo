package com.kun.demo.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
    public String getTime(){
        return "ម៉ោងបច្ចុបន្នៈ "+java.time.LocalDateTime.now();
    }
    @GetMapping("/api/name/{name}")
    public String sayHi(@PathVariable String name){
        return "សួស្តី " + name + "! រីករាយណាស់ដែលបានជួបអ្នក";
    }

    @GetMapping("/api/info")
        public Map<String, Object> getAppInfo(){
            Map<String, Object> info = new HashMap<>();
            info.put("appName", "Demo Spring Boot API");
            info.put("version", "1.0.0");
            info.put("developer", "kun");
            info.put("currenTime", LocalDateTime.now().toString());
            info.put("message", "សួស្តី!​ នេះជា JSON response ដំបូង");
            return info;
        
    }
    @GetMapping("/api/calculate/{num1}/{num2}")
        public Map<String, Object> calculate(@PathVariable int num1, @PathVariable int num2){
            Map<String, Object> result = new HashMap<>();
            result.put("num1", num1);
            result.put("num2", num2);
            result.put("sum", num1+num2);
            result.put("product", num1*num2);
            result.put("message", "ការគណនាសាមញ្ញរួចរាល់!");
            return result;
    }
}