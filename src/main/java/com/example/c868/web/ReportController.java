package com.example.c868.web;

import com.example.c868.model.CallRecord;
import com.example.c868.model.CallStatus;
import com.example.c868.model.Product;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReportController {

    //addAttributes brings in != null values
    //put

    class ProductCount {
        private String name;
        private Long total;

        public ProductCount() {
        }

        public ProductCount(String name, Long total) {
            this.name = name;
            this.total = total;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }
    }

    @Autowired
    private CallRecordService callRecordService;

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/reports")
    public String getReport(@AuthenticationPrincipal User user, ModelMap model){
        List<String> productNameList = new ArrayList<>();
        List<ProductCount> totalCountList = new ArrayList<>();
        productNameList.add("Plumbis");
        productNameList.add("Dingle Bop");
        productNameList.add("Shleem");
        productNameList.add("Grumbo");
        productNameList.add("Fleeb");
        productNameList.add("Shlomy");
        productNameList.add("Hizard");
        productNameList.add("Blamph");
        productNameList.add("Chumble");
        productNameList.add("Ploobis");
        for(int i=0; i<productNameList.size(); i++){
            ProductCount productCount = new ProductCount();
            productCount.name = productNameList.get(i);
            productCount.total = callRecordService.getCountCallRecordsByProductName(productNameList.get(i));
            totalCountList.add(productCount);
        }

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
        model.put("productList", totalCountList);
        return "reports";
    }

}
