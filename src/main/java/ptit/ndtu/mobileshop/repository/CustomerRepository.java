package ptit.ndtu.mobileshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ptit.ndtu.mobileshop.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
}
