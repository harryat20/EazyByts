package com.harry.crm.service;

import com.harry.crm.entity.Transactions;
import org.hibernate.Transaction;

import java.util.List;

public interface TransactionService {

    String insertMultipleTransactions(List<Transactions> transactions);

    String saveTransaction(Transactions transaction);

    List<Object[]> getAllTransactions();

    Transactions getTransactionById(Long id);

    String updateTransaction(Transactions transaction);

    String deleteTransactionById(Long id);
}
