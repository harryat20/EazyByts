package com.harry.crm.service;

import com.harry.crm.dao.CustomerDao;
import com.harry.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDao customerDao;

    @Override
    public String insertCustomer(Customer customer) {
        return customerDao.insertCustomer(customer);
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public String updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public String deleteCustomerById(int id) {
        return customerDao.deleteCustomerById(id);
    }

    @Override
    public String insertMultipleCustomer(List<Customer> customers) {
        return customerDao.insertMultipleCustomer(customers);
    }


}
