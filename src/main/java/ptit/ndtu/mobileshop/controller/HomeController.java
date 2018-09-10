package ptit.ndtu.mobileshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ptit.ndtu.mobileshop.entities.Account;
import ptit.ndtu.mobileshop.entities.Customer;
import ptit.ndtu.mobileshop.service.AccountService;
import ptit.ndtu.mobileshop.service.CustomerService;
import ptit.ndtu.mobileshop.tool.Validation;

@Controller
public class HomeController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/home")
	public String index() {
		return "index";
	}
	
	@GetMapping("/client/login")
	public String redirectLogin(Model model) {
		model.addAttribute("account", new Account());
		return "login";
	}
	
	@PostMapping("/client/doLogin")
	public String doLogin(@ModelAttribute Account account, RedirectAttributes redirect, HttpSession session) {
		if(accountService.login(account.getUsername(), account.getPassword())) {
			session.setAttribute("username", account.getUsername());
			return "redirect:/home";
		} else {
			redirect.addFlashAttribute("login_fail", "Login failed! Please check your account again!");
			return "redirect:/client/login";
		}
	}
	
	@GetMapping("/client/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("username")!=null) {
			session.removeAttribute("username");
		}
		return "redirect:/home";
	}
	
	@GetMapping("/client/manageProfile")
	public String manageProfile(Model model) {
		model.addAttribute("account", new Account());
		return "manage_profile";
	}
	
	@GetMapping("/client/register")
	
	public String register(Model model) {
		model.addAttribute("customer", new Customer());
		return "register";
	}
	
	@PostMapping("/client/doRegister")
	public String doRegister(@ModelAttribute Customer customer, RedirectAttributes redirect) {
		Validation tool = new Validation();
		if(!tool.checkUsername(customer.getAccountId().getUsername())) {
			redirect.addFlashAttribute("register_fail", "Username can not be blank and is 5 to 20 characters long");
			return "redirect:/";
		} 
		if(!tool.checkPassword(customer.getAccountId().getPassword())) {
			redirect.addFlashAttribute("register_fail", "Password can not be blank and is longer than 5 characters");
			return "redirect:/";
		} 
		if(!tool.checkString(customer.getCustomerName())) {
			redirect.addFlashAttribute("register_fail", "Name can not be blank");
			return "redirect:/";
		} 
		if(!tool.checkString(customer.getCustomerName())) {
			redirect.addFlashAttribute("register_fail", "Name can not be blank");
			return "redirect:/";
		}
		if(customerService.register(customer)) {
			return "redirect:/client/login";
		} else {
			redirect.addFlashAttribute("register_fail", "Register fail, your username has been existed!");
			return "redirect:/";
		}
		
	}
}
