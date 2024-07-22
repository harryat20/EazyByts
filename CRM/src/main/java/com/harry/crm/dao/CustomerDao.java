package com.harry.crm.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.harry.crm.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerDao {

    //database ka code

    @Autowired
    SessionFactory sf;

    public String insertCustomer(Customer customer)
    {
        Session session = sf.openSession();
        //insert, update, delete ---> u need to use Transaction

        Transaction tr = session.beginTransaction();

        session.merge(customer);

        tr.commit();
        session.close();

        return "Customer inserted successfully";
    }

    public List<Customer> getCustomerList()
    {
        Session session = sf.openSession();
        return session.createQuery("from Customer").list();
    }

    public Customer getCustomerById(int id)
    {
        Session session = sf.openSession();
        return session.get(Customer.class,id);
    }

    public String updateCustomer(Customer customer){
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        session.update(customer);
        tr.commit();
        session.close();

        return "Customer Updated Successfully";
    }

    public String deleteCustomerById(int id){
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();
        Customer c = session.get(Customer.class, id);
        session.delete(c);
        tr.commit();
        session.close();

        return "Customer Deleted Successfully";
    }

    public String insertMultipleCustomer(List<Customer> customers){
        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        for(Customer customer : customers){
            session.save(customer);
        }

        tr.commit();
        session.close();

        return "Customers added successfully";
    }

}
