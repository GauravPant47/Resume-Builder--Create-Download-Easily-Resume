package net.resume.building.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.ProfileDetails;
import net.resume.building.service.ProfileDetailsService;

@Controller
@RequestMapping("/home")
public class ProfileDetailsController {

	@Autowired
	private ProfileDetailsService detailsService;

	@GetMapping("/resume/profile")
	public String createNewForm(HttpServletRequest request, Model model) {

		String name = request.getParameter("name");
		String totalExperience = request.getParameter("totalExperience");
		String currentLocation = request.getParameter("currentLocation");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailAddress = request.getParameter("emailAddress");
		ProfileDetails profiles = new ProfileDetails();
		profiles.setName(name);
		profiles.setTotalExperience(totalExperience);
		profiles.setCurrentLocation(currentLocation);
		profiles.setEmailAddress(emailAddress);
		profiles.setMobileNumber(mobileNumber);

		model.addAttribute("profiles", profiles);

		return "profile_post";
	}

	@PostMapping("/resume/profile")
	public String submitForm(@ModelAttribute ProfileDetails profileDetails) {

		// model.addAttribute("profile", profile);
		detailsService.saveListItem(profileDetails);
		return "redirect:/home/resume";
	}

}
