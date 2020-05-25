package springmvcrest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springmvcrest.domain.Customer;
import springmvcrest.service.CustomerService;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
	
	public static final String BASE_URL = "/api/v1/customers";
	private final CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	/**
	 * Save customer 
	 * @param customer
	 * @return customer data
	 */
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
    
	/**
	 * Get all customer details
	 * @return all customer details
	 */
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.findAllCustomers();
	}
	
	
	/**
	 * Get customer details by Id
	 * @param id
	 * @return customer details by Id
	 */
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable Long id) {
		return customerService.findCustomerById(id);
	}


}
