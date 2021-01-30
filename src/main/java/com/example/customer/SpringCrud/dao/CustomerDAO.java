package com.example.customer.SpringCrud.dao;

import com.example.customer.SpringCrud.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    Customer getCustomer(int id);
}
