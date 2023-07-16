package net.resume.building.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class RegistrationController {

	@GetMapping("/registra")
	public String registraPage() {
		return "registra";
	}
}
