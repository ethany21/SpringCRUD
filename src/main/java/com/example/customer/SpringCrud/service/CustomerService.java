package com.example.customer.SpringCrud.service;

import com.example.customer.SpringCrud.entity.Customer;
import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    Customer getCustomer(int id);
}
