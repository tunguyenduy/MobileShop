package ptit.ndtu.mobileshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ptit.ndtu.mobileshop.repository.AccountRepository;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	

	@Override
	public boolean login(String username, String password) {
		if(accountRepository.findByUsernameAndPasswordAndRole(username, password)==null) {
			return false;
		} else {
			return true;
		}
	}

}
