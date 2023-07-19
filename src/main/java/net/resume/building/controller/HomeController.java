package net.resume.building.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping("")
	public String homePage() {
		return "index";
	}

	// @GetMapping("/resume")
	// public String resumePage() {
	// return "resume";
	// }

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/resumef")
	public String resumePage() {
		return "resumef";
	}

	@GetMapping("/resumes")
	public String resumesPage() {
		return "resumes";
	}

	@GetMapping("/resumet")
	public String resumetPage() {
		return "resumet";
	}
}
