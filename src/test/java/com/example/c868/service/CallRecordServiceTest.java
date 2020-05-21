package com.example.c868.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.c868.model.CallRecord;
import com.example.c868.model.CallStatus;
import com.example.c868.repositories.CallRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CallRecordServiceTest {

    @Autowired
    private CallRepository callRepository;

    private CallRecordService callRecordService;

    @Test
    void verifyCallRecordList() {

        int expected = 11;
        int actual;

        List<CallRecord> callRecordList = new ArrayList<>();
        callRecordList = callRepository.findAll();
        actual = callRecordList.size();
        assertEquals(expected, actual, "Total Size of the  list  of all call records returned");

        System.out.println();
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + actual);

    }

    @Test
    void verifyCallRecordStatusIsClosed() {

        int expected = 6;

        Long callCount = callRepository.countCallRecordsByStatus(CallStatus.CLOSED);
        assertEquals(expected, callCount, "Total call record count with the status of CLOSED");

        System.out.println();
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + callCount);

    }
}