package com.soft1851.spring.annotation_web.controller;


import com.soft1851.spring.annotation_web.entity.Fruit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author wl
 * @ClassNameHomeController
 * @Description TODO
 * @Date 2020/3/24
 * @Version 1.0
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello Spring Mvc");
        List<Fruit> fruits = new ArrayList<>(3);

        Collections.addAll(fruits,
                Fruit.builder().name("Orange").img("http://ww1.sinaimg.cn/large/006bA45kgy1gd52ms1b53j302s02sgle.jpg")
                        .intro("Orange (colour), occurs between red and yellow in the visible spectrum").color("#FF9933").build(),
                Fruit.builder().name("Cherry").img("http://ww1.sinaimg.cn/large/006bA45kgy1gd52m9xocij302s02st8i.jpg")
                        .intro("A cherry is the fruit of many plants of the genus Prunus, and is a fleshy drupe.").color("#FF0033").build(),
                Fruit.builder().name("Tomato").img("http://ww1.sinaimg.cn/large/006bA45kgy1gd52lpn4r2j302s02s0sj.jpg")
                        .intro("The tomato is the edible, often red, berry of the plant Solanum lycopersicum").color("#FF3333").build());
        model.addAttribute("fruits", fruits);
        return "home";
    }
}
