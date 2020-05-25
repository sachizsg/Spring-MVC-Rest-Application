package springmvcrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springmvcrest.domain.Customer;
import springmvcrest.domain.repositories.CustomerRepository;

@Component
public class BootStrapData implements CommandLineRunner {
   
	private final CustomerRepository customerRepository;
	
    public BootStrapData(CustomerRepository customerRepository) {
    	this.customerRepository = customerRepository;	
	}
    
	@Override
	public void run(String... args) throws Exception {
	   
		/**
		 * Loding customer data
		 */
		System.out.println("Loding customer data");
		
		Customer customer = new Customer();
		customer.setFirstName("Michale");
		customer.setLastName("Weston");
		customerRepository.save(customer);
		
		Customer customerNew = new Customer();
		customerNew.setFirstName("Sam");
		customerNew.setLastName("Axe");
		customerRepository.save(customerNew);
		
		Customer customerNewSet = new Customer();
		customerNewSet.setFirstName("Anjalo");
		customerNewSet.setLastName("Barns");
		customerRepository.save(customerNewSet);
		
		System.out.println("Customer Saved: " + customerRepository.count());
		
	}
	

}
