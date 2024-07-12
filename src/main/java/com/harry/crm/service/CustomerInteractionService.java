package com.harry.crm.service;

import com.harry.crm.entity.CustomerInteraction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerInteractionService {

    String saveCustomerInteraction(CustomerInteraction customerInteraction);

    List<Object[]> getAllCustomerInteractions();

    CustomerInteraction getCustomerInteractionById(Long id);

    List<CustomerInteraction> getInteractionsByCustomerId(Long customerId);

    String updateCustomerInteraction(CustomerInteraction customerInteraction);

    String deleteCustomerInteractionById(Long id);
}
