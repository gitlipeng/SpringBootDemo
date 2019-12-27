package com.example.demo.controller;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.example.demo.entity.Person;
import com.example.demo.mappper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    PersonMapper personMapper;
    @GetMapping("/test")
    public void test() {
        Person person = new Person();
        person.setAge(12);
        person.setName("lipeng");
        personMapper.addPerson();

//        HttpResponse httpResponse = HttpUtil.createGet("http://172.19.50.42:11090/i18n").execute();
////                .header("Authorization", getToken())
////                .form(model.getParam())
//
//        System.out.println(httpResponse.body());
    }
}
