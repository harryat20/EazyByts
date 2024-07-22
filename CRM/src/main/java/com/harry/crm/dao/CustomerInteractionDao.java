package com.harry.crm.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.harry.crm.entity.CustomerInteraction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerInteractionDao {

    @Autowired
    private SessionFactory sessionFactory;

    public String insertCustomerInteraction(CustomerInteraction customerInteraction) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(customerInteraction);
        tr.commit();
        return "Customer interaction saved successfully";
    }

    public List<Object[]> getAllCustomerInteractions() {
        Session session = sessionFactory.openSession();
        List<Object[]> interactions = session.createQuery("select ct.id, ct.interactionType, ct.interactionDate, ct.notes from CustomerInteraction ct").list();
        session.close();
        return interactions;
    }

    public CustomerInteraction getCustomerInteractionById(Long id) {
        Session session = sessionFactory.openSession();
        CustomerInteraction t = session.get(CustomerInteraction.class,id);
        session.close();
        return t;
    }

    public List<CustomerInteraction> getInteractionsByCustomerId(Long customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM CustomerInteraction ci WHERE ci.customer.id = :customerId", CustomerInteraction.class)
                .setParameter("customerId", customerId)
                .getResultList();
    }

    public String updateCustomerInteraction(CustomerInteraction customerInteraction) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customerInteraction);
        return "Customer interaction updated successfully";
    }

    public String deleteCustomerInteractionById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        CustomerInteraction interaction = session.get(CustomerInteraction.class, id);
        session.delete(interaction);
        return "Customer interaction deleted successfully";
    }
}
