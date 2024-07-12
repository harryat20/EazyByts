package com.harry.crm.controller;

import com.harry.crm.entity.Transactions;
import com.harry.crm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public String insertMultipleTransactions(@RequestBody List<Transactions> transactions){
        return transactionService.insertMultipleTransactions(transactions);
    }

    @PostMapping("/add")
    public String addTransaction(@RequestBody Transactions transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Object[]> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transactions getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PutMapping("/update")
    public String updateTransaction(@RequestBody Transactions transaction) {
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        return transactionService.deleteTransactionById(id);
    }
}
