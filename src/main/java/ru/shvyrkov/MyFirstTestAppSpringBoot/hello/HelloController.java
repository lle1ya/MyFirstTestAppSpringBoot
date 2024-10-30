package ru.shvyrkov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class HelloController {
    List<String> myList = null;
    Map<Integer, String> myMap = null;
    int key = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s", name);
    }

    @GetMapping("/update-array/{s}")
    public String updateArrayList(@PathVariable String s) {
        if (myList == null) {
            myList = new ArrayList<>();
            return "Список создан";
        } else {
            myList.add(s);
            return s;
        }
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        return myList;
    }

    @GetMapping("/update-map/{s}")
    public String updateHashMap(@PathVariable String s) {
        if (myMap == null) {
            myMap = new HashMap<>();
            return "HashMap создан";
        } else {
            myMap.put(key, s);
            key++;
            return s;
        }
    }
    @GetMapping("/show-map")
    public Map<Integer, String> showAHashMap() {
        return myMap;
    }
    @GetMapping("/show-all-lenght")
    public int showAllLenght(){
        return myMap.size() + myList.size();
    }
}