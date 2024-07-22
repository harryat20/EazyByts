package com.harry.crm.service;

import com.harry.crm.dao.TransactionDao;
import com.harry.crm.entity.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;



    @Override
    public String insertMultipleTransactions(List<Transactions> transactions){
        return transactionDao.insertMultipleTransactions(transactions);
    }

    @Override
    public String saveTransaction(Transactions transaction) {
        return transactionDao.insertTransaction(transaction);
    }

    @Override
    public List<Object[]> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    @Override
    public Transactions getTransactionById(Long id) {
        return transactionDao.getTransactionById(id);
    }

    @Override
    public String updateTransaction(Transactions transaction) {
        return transactionDao.updateTransaction(transaction);
    }

    @Override
    public String deleteTransactionById(Long id) {
        return transactionDao.deleteTransactionById(id);
    }
}
