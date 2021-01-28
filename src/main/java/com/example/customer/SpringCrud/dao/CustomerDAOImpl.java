package com.example.customer.SpringCrud.dao;

import com.example.customer.SpringCrud.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        //create a query
        Query<Customer> query = session.createQuery("FROM Customer c", Customer.class);

        // execute query and get result list

        List<Customer> customers = query.getResultList();

        //return the results


        return customers;
    }
}
