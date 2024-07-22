package com.harry.crm.controller;

import com.harry.crm.entity.CustomerInteraction;
import com.harry.crm.service.CustomerInteractionService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-interactions")
public class CustomerInteractionController {

    @Autowired
    private CustomerInteractionService customerInteractionService;

    @PostMapping
    public String saveCustomerInteraction(@RequestBody CustomerInteraction customerInteraction) {
        return customerInteractionService.saveCustomerInteraction(customerInteraction);
    }

    @GetMapping
    public List<Object[]> getAllCustomerInteractions() {
        return customerInteractionService.getAllCustomerInteractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInteraction> getCustomerInteraction(@PathVariable Long id) {
        CustomerInteraction customerInteraction = customerInteractionService.getCustomerInteractionById(id);
        Hibernate.initialize(customerInteraction.getCustomer().getInteractions()); // Explicitly initialize
        return ResponseEntity.ok(customerInteraction);
    }

    @GetMapping("/by-customer/{customerId}")
    public List<CustomerInteraction> getInteractionsByCustomerId(@PathVariable Long customerId) {
        return customerInteractionService.getInteractionsByCustomerId(customerId);
    }

    @PutMapping("/{id}")
    public String updateCustomerInteraction(@PathVariable Long id, @RequestBody CustomerInteraction customerInteraction) {
        customerInteraction.setId(id);
        return customerInteractionService.updateCustomerInteraction(customerInteraction);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomerInteractionById(@PathVariable Long id) {
        return customerInteractionService.deleteCustomerInteractionById(id);
    }
}
