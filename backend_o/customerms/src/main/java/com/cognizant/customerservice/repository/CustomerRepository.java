package com.cognizant.customerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.customerservice.model.CustomerEntity;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, String> {
    List<CustomerEntity> findAll();
}
