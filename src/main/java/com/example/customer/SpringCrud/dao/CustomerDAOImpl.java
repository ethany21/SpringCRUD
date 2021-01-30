package com.example.customer.SpringCrud.dao;

import com.example.customer.SpringCrud.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create a query
        Query<Customer> query = session.createQuery("FROM Customer ORDER BY lastName", Customer.class);
        // execute query and get result list
        List<Customer> customers = query.getResultList();

        //return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        return customer;
    }
}
