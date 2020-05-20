package com.example.c868.web;

import com.example.c868.model.CallStatus;
import com.example.c868.model.User;
import com.example.c868.repositories.CallRepository;
import com.example.c868.repositories.ProductRepository;
import com.example.c868.service.CallRecordService;
import com.example.c868.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    //addAttributes brings in != null values
    //put

    @Autowired
    private CallRecordService callRecordService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/reports")
    public String getReport(@AuthenticationPrincipal User user, ModelMap model){
        model.put("user", user);
        model.put("callRecord", callRecordService.getAllCallRecords());
        model.put("totalCalls", callRecordService.getCallRecordCount());
        model.put("closedCalls", callRecordService.getCallRecordsCountByStatus(CallStatus.CLOSED));
        model.put("onHoldCalls", callRecordService.getCallRecordsCountByStatus(CallStatus.ON_HOLD));
        model.put("inProgressCalls", callRecordService.getCallRecordsCountByStatus(CallStatus.IN_PROGRESS));
        model.put("urgentCalls", callRecordService.getCallRecordsCountByStatus(CallStatus.URGENT));
        model.put("apertureCalls", callRecordService.getCallRecordsCountByCustomerName("Aperture Laboratories"));
        model.put("clampCalls", callRecordService.getCallRecordsCountByCustomerName("Clamp Corporation"));
        model.put("starkCalls", callRecordService.getCallRecordsCountByCustomerName("Stark Industries"));
        model.put("acmeCalls", callRecordService.getCallRecordsCountByCustomerName("ACME Corporation"));
        model.put("productNames", productService.getDistinctProductName());
        model.put("productCount", callRecordService.getCountCallRecordsByProductName());
        return "reports";
    }

}
