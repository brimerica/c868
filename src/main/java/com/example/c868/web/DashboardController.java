package com.example.c868.web;

import com.example.c868.model.*;
import com.example.c868.repositories.CallRepository;
import com.example.c868.repositories.UserRepository;
import com.example.c868.security.Authority;
import com.example.c868.service.CallRecordService;
import com.example.c868.service.ProductService;
import com.example.c868.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.weaver.ast.Call;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Controller
public class DashboardController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    private CallRecordService callRecordService;
    private CallRepository callRepository;

    @Autowired
    private ProductService productService;


    @GetMapping(value="/")
    public String rootView(){
        return "index";
    }

    @GetMapping(value="/dashboard")
    public String dashboardView(@AuthenticationPrincipal User user, ModelMap model){
        model.addAttribute("user", userService.getUserByName(user.getName()));
        model.addAttribute("callRecord", callRecordService.getAllCallRecords());
        return "dashboard";
    }

    @GetMapping(value="/register")
    public String register(ModelMap model){
        model.put("user", new User());
        model.put("authority", new Authority());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(User user, Authority authority){
        userService.save(user, authority);
        return "redirect:/dashboard";
    }

    @PostMapping(value="/dashboard")
    public String dashboardPost(@AuthenticationPrincipal User user, CallRecord callRecord, Comment comment, Product product){
        comment.setCallRecord(callRecord);
        comment.setDateCreated(new Date());
        comment.setUser(user);

        callRecord.setUser(user);
        callRecord.getComments().add(comment);
        callRecord.setProduct(productService.save(product));
        callRecord.setDateCreated(new Date());

        callRecordService.save(callRecord);
        return "redirect:/dashboard";
    }

    @GetMapping(value="/dashboard/{callRecordId}")
    public String deleteCall(@PathVariable Long callRecordId){
        callRecordService.delete(callRecordId);
        return "redirect:/dashboard";
    }

}
