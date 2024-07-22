package com.harry.crm.service;

import com.harry.crm.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    String insertCustomer(Customer customer);

    List<Customer> getCustomerList();

    Customer getCustomerById(int id);

    String updateCustomer(Customer customer);

    String deleteCustomerById(int id);

    String insertMultipleCustomer(List<Customer> customers);

}
