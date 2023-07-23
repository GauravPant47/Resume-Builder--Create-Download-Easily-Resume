package net.resume.building.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.resume.building.model.Account;
import net.resume.building.service.AccountService;

@Controller
public class RegistrationController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/registra")
	public String registraPage(Model model) {
		Account account = new Account();
		model.addAttribute("account", account);
		return "registra";
	}
	
	@PostMapping("/registra")
	public String savePage(@ModelAttribute Account account) {
		accountService.save(account);
		return "redirect:/home";
	}
}
