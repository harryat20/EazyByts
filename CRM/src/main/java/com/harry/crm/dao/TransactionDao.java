package com.harry.crm.dao;

import com.harry.crm.entity.Customer;
import com.harry.crm.entity.Transactions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class TransactionDao {

    @Autowired
    SessionFactory sf;

    public String insertMultipleTransactions(List<Transactions> transactions){
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        for(Transactions transactions1 : transactions){
            session.save(transactions1);
        }

        tr.commit();
        session.close();

        return "Customers added successfully";
    }

    public String insertTransaction(Transactions transaction) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        session.save(transaction);
        tr.commit();
        session.close();
        return "Transaction inserted successfully";
    }

    public List<Object[]> getAllTransactions() {
        Session session = sf.openSession();
        List<Object[]> transactions = session.createQuery("select t.id, t.amount, t.transactionDate, t.customer.id from Transactions t").list();
        session.close();
        return transactions;
    }

    public Transactions getTransactionById(Long id) {
        Session session = sf.openSession();
        Transactions transactions = session.get(Transactions.class, id);
        session.close();
        return transactions;
    }

    public String updateTransaction(Transactions transaction) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        // Fetch the associated Customer entity and set it to the transaction
        if (transaction.getCustomer() != null && transaction.getCustomer().getId() != null) {
            Customer customer = session.get(Customer.class, transaction.getCustomer().getId());
            if (customer != null) {
                transaction.setCustomer(customer);
            }
        }

        session.update(transaction);
        tr.commit();
        session.close();
        return "Transaction updated successfully";
    }

    public String deleteTransactionById(Long id) {
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        Transactions transactions = session.get(Transactions.class, id);
        session.delete(transactions);
        tr.commit();
        session.close();
        return "Transaction deleted successfully";
    }
}
