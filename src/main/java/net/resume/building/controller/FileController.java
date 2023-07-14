package net.resume.building.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.EmploymentModel;
import net.resume.building.model.ProfileDetails;
import net.resume.building.service.EmploymentService;
import net.resume.building.service.ProfileDetailsService;

@Controller
@RequestMapping("/home")
public class FileController {

	@Autowired
	private ProfileDetailsService detailsService;

	@Autowired
	private EmploymentService employmentService;

	@GetMapping("/form")
	public String showForm(Model model) {
		ProfileDetails profile = new ProfileDetails();
		model.addAttribute("profile", profile);
		EmploymentModel employment = new EmploymentModel();
		model.addAttribute("eployment", employment);

		return "form";
	}

	@PostMapping("/submit")
	public String submitForm(HttpServletRequest request, @ModelAttribute ProfileDetails profileDetails,
			@ModelAttribute EmploymentModel employmentModel, Model model) {

		// TODO: Profile Details
		String name = request.getParameter("name");
		String totalExperience = request.getParameter("totalExperience");
		String currentLocation = request.getParameter("currentLocation");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailAddress = request.getParameter("emailAddress");

		// TODO: Employment Model
		String employmentType = request.getParameter("employmentType");
		String experience = request.getParameter("totalExperience");
		String companyName = request.getParameter("companyName");
		String designation = request.getParameter("designation");
		String joiningDate = request.getParameter("joiningDate");
		String workedTill = request.getParameter("workedTill");
		String jobProfile = request.getParameter("jobProfile");

		// Create instances of Profile, Employment, and using the retrieved data

		ProfileDetails profile = new ProfileDetails();

		profile.setName(name);
		profile.setCurrentLocation(currentLocation);
		profile.setMobileNumber(mobileNumber);
		profile.setEmailAddress(emailAddress);
		profile.setTotalExperience(totalExperience);
		profile.setImage(profileDetails.getImage());

		EmploymentModel eployment = new EmploymentModel();

		eployment.setEmploymentType(employmentType);
		eployment.setTotalExperience(experience);
		eployment.setCompanyName(companyName);
		eployment.setDesignation(designation);
		eployment.setJoiningDate(joiningDate);
		eployment.setWorkedTill(workedTill);
		eployment.setJobProfile(jobProfile);

		// TODO:
		model.addAttribute("profile", profile);
		model.addAttribute("eployment", eployment);

		// TODO: Save Data to updating

		detailsService.saveListItem(profileDetails);

		employmentService.saveAllFile(employmentModel);

		return "redirect:/home/form";
	}
}
