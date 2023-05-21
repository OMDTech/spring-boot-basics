package com.springboot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


// Business Layer
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void createCustomer(CustomerRequestBody request) {
        Customer customer = new Customer();
        customer.setAge(request.age());
        customer.setName(request.name());
        customer.setEmail(request.email());
        customerRepository.save(customer);
    }

    public Customer deleteCustomer(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        customerRepository.deleteById(id);
        Customer notFound = new Customer();
        notFound.setName("No Customer Found");
        return customer.orElse(notFound);
    }

    public Customer updateCustomer(Integer id, CustomerRequestBody requestBody) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(requestBody.name());
        customer.setEmail(requestBody.email());
        customer.setAge(requestBody.age());
        Optional<Customer> exists = customerRepository.findById(id);
        exists.ifPresent(a -> customerRepository.save(customer));
        Customer notFound = new Customer();
        notFound.setName("No Customer Found");
        return exists.orElse(notFound);
    }
}
