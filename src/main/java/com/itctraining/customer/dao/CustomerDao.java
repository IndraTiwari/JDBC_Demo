package com.itctraining.customer.dao;

import com.itctraining.customer.model.Customer;

public interface CustomerDao {
public void insert(Customer customer);
public Customer findByCustomerId(int custId);
}
