package com.roll31.lab3.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roll31.lab3.DTO.TypeValue;
import com.roll31.lab3.entity.CUST_ADDRESS;

public interface CustomerAddressRepository extends JpaRepository<CUST_ADDRESS, Long>{
    @Query(value = "select c.CSTCL_TYP_VALUE, a.CSTADD_VALUE from CUST_ADDRESS a JOIN CUST_CL c on a.cstadd_cls_id = c.cstcl_id where a.cst_id = :cust_idfr", nativeQuery = true)
    List<TypeValue> findCustomerAddress(@Param("cust_idfr") Long cust_idfr);
}
