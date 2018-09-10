package ptit.ndtu.mobileshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ptit.ndtu.mobileshop.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Query(value="Select a.* from Account a where a.username =:username and a.password =:password and a.role = 1 and a.status = 1 and a.account_id <> 0", nativeQuery = true)
	Account findByUsernameAndPasswordAndRole(@Param("username") String username,@Param("password") String password);
	
	@Query(value="Select a.* from Account a where a.username =:username", nativeQuery=true)
	Account findByUsername(@Param("username") String username);
}
