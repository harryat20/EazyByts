package com.harry.crm.service;

import com.harry.crm.dao.CustomerInteractionDao;
import com.harry.crm.entity.CustomerInteraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerInteractionServiceImpl implements CustomerInteractionService {

    @Autowired
    private CustomerInteractionDao customerInteractionDao;


    public String saveCustomerInteraction(CustomerInteraction interaction) {
        return customerInteractionDao.insertCustomerInteraction(interaction);
    }

    @Override
    public List<Object[]> getAllCustomerInteractions() {
        return customerInteractionDao.getAllCustomerInteractions();
    }

    @Override
    public CustomerInteraction getCustomerInteractionById(Long id) {
        return customerInteractionDao.getCustomerInteractionById(id);
    }

    @Override
    public List<CustomerInteraction> getInteractionsByCustomerId(Long customerId) {
        return customerInteractionDao.getInteractionsByCustomerId(customerId);
    }

    @Override
    public String updateCustomerInteraction(CustomerInteraction customerInteraction) {
        return customerInteractionDao.updateCustomerInteraction(customerInteraction);
    }

    @Override
    public String deleteCustomerInteractionById(Long id) {
        return customerInteractionDao.deleteCustomerInteractionById(id);
    }
}
