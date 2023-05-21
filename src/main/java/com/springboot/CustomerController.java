package com.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//API Layer

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // used to expose the method as a rest endpoint  for clients to use as Get Request
    // when we use RequestMapping as standard path we dont need to provide any path from the REST API
    @GetMapping
    public List<Customer> getCustomers() {
        // use jackson to convert to JSON
        return customerService.getCustomers();
    }

    @PostMapping("/create/customer")
    public void createCustomer(@RequestBody CustomerRequestBody request) {
        customerService.createCustomer(request);
    }

    @DeleteMapping("delete/customer/{customerId}")
    public Customer deleteCustomer(@PathVariable("customerId") Integer id) {
        return customerService.deleteCustomer(id);
    }

    @PutMapping("update/customer/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") Integer id, @RequestBody CustomerRequestBody requestBody) {
        return customerService.updateCustomer(id, requestBody);
    }
}
