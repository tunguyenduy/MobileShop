package ptit.ndtu.mobileshop.service;

import org.springframework.beans.factory.annotation.Autowired;

import ptit.ndtu.mobileshop.entities.Customer;
import ptit.ndtu.mobileshop.repository.AccountRepository;
import ptit.ndtu.mobileshop.repository.CustomerRepository;

public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	public CustomerRepository customerRepository;
	@Autowired
	public AccountRepository accountRepository;
	
	
	@Override
	public boolean register(Customer customer) {
		try {
			if(accountRepository.findByUsername(customer.getAccountId().getUsername())==null) {
				customerRepository.save(customer);
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
