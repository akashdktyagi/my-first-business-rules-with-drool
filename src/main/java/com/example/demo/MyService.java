package com.example.demo;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MyService {

    @Autowired
    private KieContainer kieContainer;

    public MyCFPojo getComplianceFWForProject(MyProjectPojo myProjectPojo){
//        Map<String, List<String>> listOfProjects = getMaturityMatrix();
        Map<String, String> maturityMatrix = getMaturityMatrix();
        MyCFPojo myCFPojo = new MyCFPojo();

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("myCFPojo", myCFPojo);
        kieSession.setGlobal("maturityMatrix", maturityMatrix);
        kieSession.insert(myProjectPojo);
        kieSession.fireAllRules();
        kieSession.dispose();
        return myCFPojo;
    }

//    public Map<String, List<String>> getMaturityMatrix(){
//        Map<String,List<String>> listOfProjects= new HashMap<String,List<String>>();
//        listOfProjects.put("LOW_MATURITY", Arrays.asList("1","2","3"));
//        listOfProjects.put("MEDIUM_MATURITY", Arrays.asList("1","2","3"));
//        listOfProjects.put("HIGH_MATURITY", Arrays.asList("1","2","3"));
//        return listOfProjects;
//    }

    public Map<String, String> getMaturityMatrix(){
        Map<String,String> listOfProjects= new HashMap<String,String>();
        listOfProjects.put("LOW_MATURITY", "1,2,3");
        listOfProjects.put("MEDIUM_MATURITY", "4,5,6");
        listOfProjects.put("HIGH_MATURITY", "7,8,9");
        return listOfProjects;
    }

}
