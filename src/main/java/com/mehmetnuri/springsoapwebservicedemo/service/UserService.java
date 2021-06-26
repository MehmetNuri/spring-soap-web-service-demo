package com.mehmetnuri.springsoapwebservicedemo.service;

import com.mehmetnuri.spring_boot_soap_web_service_demo.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User mehmet = new User();
        mehmet.setName("Mehmet");
        mehmet.setEmpId(1111);
        mehmet.setSalary(12000);

        User ogeday = new User();
        ogeday.setName("Ögeday");
        ogeday.setEmpId(1112);
        ogeday.setSalary(32000);

        User rasim = new User();
        rasim.setName("Rasim");
        rasim.setEmpId(1113);
        rasim.setSalary(16000);

        User kudret = new User();
        kudret.setName("Kudret");
        kudret.setEmpId(1113);
        kudret.setSalary(126000);

        users.put(mehmet.getName(), mehmet);
        users.put(ogeday.getName(), ogeday);
        users.put(rasim.getName(), rasim);
        users.put(kudret.getName(), kudret);
    }


    public User getUsers(String name) {
        return users.get(name);
    }
}
