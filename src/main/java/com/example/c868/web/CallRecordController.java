package com.example.c868.web;

import com.example.c868.model.*;
import com.example.c868.repositories.CallRepository;
import com.example.c868.service.CallRecordService;
import com.example.c868.service.CommentService;
import com.example.c868.service.ProductService;
import com.example.c868.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class CallRecordController {

    @Autowired
    private CallRecordService callRecordService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/newcall")
    public String newCallRecord(@AuthenticationPrincipal User user, ModelMap model){

        model.put("user", user);
        model.put("product", new Product());
        model.put("callRecord", new CallRecord());
        model.put("comment", new Comment());
        return "newcall";
    }

    @PostMapping(value = "/newcomment/{callRecordId}")
    public String newComment(@PathVariable String callRecordId, @AuthenticationPrincipal User user, Comment comment){
        Long convertedId = Long.valueOf(callRecordId);
//        List<Comment> allCallComments;

        comment.setUser(user);
        comment.setDateCreated(new Date());
        comment.setCallRecord(callRecordService.getCallRecord(convertedId));
        commentService.save(comment);
        callRecordService.getCallRecord(convertedId).getComments().add(comment);
//        allCallComments = commentService.getCommentsByCallRecordId(convertedId);
//        allCallComments.add(comment);

        return "redirect:/updatecall/{callRecordId}";
    }

    @PostMapping(value = "/updatecall/{callRecordId}")
    public String updateCallRecord(@PathVariable String callRecordId, CallRecord callRecord){
        Long convertedId = Long.valueOf(callRecordId);
        callRecord.setUser(userService.getUserById(callRecord.getUser().getId()));
        callRecord.setComments(commentService.getCommentsByCallRecordId(convertedId));
        callRecord.setDateCreated(callRecordService.getCallRecord(convertedId).getDateCreated());
        productService.save(callRecord.getProduct());
        if(callRecord.getStatus().equals(CallStatus.CLOSED)){
            callRecord.setDateCompleted(new Date());
        }
        callRecordService.save(callRecord);
        return "redirect:/dashboard";
    }

    @GetMapping(value = "/updatecall/{callRecordId}")
    public String getCallRecord(@AuthenticationPrincipal User user, ModelMap model, @PathVariable String callRecordId){
        Long convertedId = Long.valueOf(callRecordId);
        model.put("callRecord", callRecordService.getCallRecord(convertedId));
        model.put("currentUser", userService.getUserById(user.getId()));
//        model.put("product", callRecordService.getCallRecord(convertedId).getProduct());
        model.put("addedComment", new Comment());
        return "updatecall";
    }

}
