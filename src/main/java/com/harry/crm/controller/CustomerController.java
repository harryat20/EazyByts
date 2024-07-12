package com.harry.crm.controller;

import com.harry.crm.dao.CustomerDao;
import com.harry.crm.entity.Customer;
import com.harry.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getCustomerList();
        model.addAttribute("customers", customers);
        return "home"; // Return the view name where you want to display the data
    }

    @PostMapping("/insert")
        public String insertCustomer(@RequestBody Customer customer)
    {
        return customerService.insertCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers()
    {
        return customerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id){
        return customerService.getCustomerById(id);
    }

    @PutMapping()
    public String updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerById(@PathVariable int id){
        return customerService.deleteCustomerById(id);
    }

    @PostMapping
    public String insertMultipleCustomer(@RequestBody List<Customer> customers){
        return customerService.insertMultipleCustomer(customers);
    }

}
