package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/hello/{projectId}")
    public MyCFPojo hello(@PathVariable Integer projectId){
        MyProjectPojo myProjectPojo = new MyProjectPojo("Project:"+ projectId,projectId);
        MyCFPojo myCFPojo = myService.getComplianceFWForProject(myProjectPojo);
        return myCFPojo;
    }
}
