package com.example.c868.repositories;

import com.example.c868.model.CallRecord;
import com.example.c868.model.CallStatus;
import com.example.c868.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<CallRecord, Long> {

    //List<CallRecord> findAllByIdNotNull();

    Long countCallRecordsByCustName(String custName);

    Long countCallRecordsByStatus(CallStatus callStatus);

    @Query("select COUNT(cr), p.name from CallRecord cr join Product p on cr.id = p.id GROUP BY p.name")
    List<Object> countCallRecordsByProductName();

}
