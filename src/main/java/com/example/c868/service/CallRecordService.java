package com.example.c868.service;

import com.example.c868.model.*;
import com.example.c868.repositories.CallRepository;
import com.example.c868.repositories.CommentRepository;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CallRecordService {

    @Autowired
    private CallRepository callRepository;

    @Autowired
    private CommentRepository commentRepository;

    public CallRecord save(CallRecord callRecord){
        return callRepository.save(callRecord);
    }

    public void delete(Long callRecordId){
        callRepository.deleteById(callRecordId);
    }

    public CallRecord getCallRecord(Long callRecordId){
        CallRecord createCallRecord = new CallRecord();
        Optional<CallRecord> callRecordOpt = callRepository.findById(callRecordId);

        if(callRecordOpt.isPresent()){
            createCallRecord = callRecordOpt.get();
        }
        return createCallRecord;
    }

    public List<CallRecord> getAllCallRecords(){
        return callRepository.findAll();
    }

//    public List<CallRecord> getFilteredCallRecords(String search){
//        return callRepository.
//    }

    public List<Comment> getCallRecordComments(Long callRecordId){
        return commentRepository.findCommentsByCallRecord_Id(callRecordId);
    }

    public Long getCallRecordsCountByStatus(CallStatus status){
        return callRepository.countCallRecordsByStatus(status);
    }

    public Long getCallRecordsCountByCustomerName(String customerName){
        return callRepository.countCallRecordsByCustName(customerName);
    }

    public Long getCallRecordCount(){
        return callRepository.count();
    }

    public Long getCountCallRecordsByProductName(String product){
        return callRepository.countCallRecordsByProductName(product);
    }

}
