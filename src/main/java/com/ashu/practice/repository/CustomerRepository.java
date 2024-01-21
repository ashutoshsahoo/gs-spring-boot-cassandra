package com.ashu.practice.repository;

import com.ashu.practice.model.Customer;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findByFirstname(String firstname);

    @AllowFiltering
    List<Customer> findByAgeGreaterThan(int age);
}
