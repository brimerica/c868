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

    Long countCallRecordsByProductName(String product);

/*    @Query("select p.name, COUNT(*) from call_record cr join product p on cr.product_id = p.id GROUP BY p.name");
    List<CallRecord> countCallRecordsByProductName();*/

}
