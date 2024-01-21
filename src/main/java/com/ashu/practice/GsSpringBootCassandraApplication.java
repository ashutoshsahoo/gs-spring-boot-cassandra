package com.ashu.practice;

import com.ashu.practice.model.Customer;
import com.ashu.practice.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class GsSpringBootCassandraApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(GsSpringBootCassandraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        clearData();
        saveData();
        lookup();
        System.exit(0);
    }


    public void clearData() {
        customerRepository.deleteAll();
        log.info("Data cleanup successful");
    }

    public void saveData() {
        log.info("=================== Save Customers to Cassandra : Start ===================");
        Customer cust_1 = new Customer(1, "Peter", "Smith", 20);
        Customer cust_2 = new Customer(2, "Mary", "Taylor", 25);
        Customer cust_3 = new Customer(3, "Peter", "Brown", 30);
        Customer cust_4 = new Customer(4, "Lauren", "Taylor", 20);
        Customer cust_5 = new Customer(5, "Lauren", "Flores", 45);
        Customer cust_6 = new Customer(6, "Peter", "Williams", 20);

        // Save customers to cassandra
        customerRepository.save(cust_1);
        customerRepository.save(cust_2);
        customerRepository.save(cust_3);
        customerRepository.save(cust_4);
        customerRepository.save(cust_5);
        customerRepository.save(cust_6);
        log.info("=================== Save Customers to Cassandra : Successful ===================");
    }

    public void lookup() {
        log.info("=================== Lookup Customers from Cassandra by Firstname : Start ===================");
        List<Customer> peters = customerRepository.findByFirstname("Peter");
        peters.forEach(c -> log.info("Customers with first name=Peter: {}", c));
        log.info("=================== Lookup Customers from Cassandra by Firstname : Successful ===================");

        log.info("=================== Lookup Customers from Cassandra by Age :Start ===================");
        List<Customer> custsAgeGreaterThan25 = customerRepository.findByAgeGreaterThan(25);
        custsAgeGreaterThan25.forEach(c -> log.info("Customers with age greater than 25: {}", c));
        log.info("=================== Lookup Customers from Cassandra by Age : Successful ===================");
    }
}
