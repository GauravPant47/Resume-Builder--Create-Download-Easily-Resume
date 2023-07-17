package net.resume.building.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.resume.building.model.EducationModel;
import net.resume.building.model.EmploymentModel;
import net.resume.building.model.ITSkillsModel;
import net.resume.building.model.KeySkillsModel;
import net.resume.building.model.ProfileDetails;
import net.resume.building.model.ProfileImageModel;
import net.resume.building.model.ProjectModel;
import net.resume.building.model.ResumeHeadlineModel;
import net.resume.building.service.EducationService;
import net.resume.building.service.EmploymentService;
import net.resume.building.service.ITSkillsService;
import net.resume.building.service.KeySkillService;
import net.resume.building.service.ProfileDetailsService;
import net.resume.building.service.ProfileImageService;
import net.resume.building.service.ProjectService;
import net.resume.building.service.ResumeHedlineService;

@Controller
@RequestMapping("/home")
public class FileController {

	@Autowired
	private ProfileDetailsService detailsService;

	@Autowired
	private EmploymentService employmentService;

	@Autowired
	private ProfileImageService profileImageService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EducationService educationService;

	@Autowired
	private ResumeHedlineService resumeHedlineService;

	@Autowired
	private ITSkillsService itSkillsService;

	@Autowired
	private KeySkillService keySkillService;

	@GetMapping("/resume")
	public String showForm(Model model) {
		ProfileDetails profile = new ProfileDetails();
		model.addAttribute("profile", profile);

		EmploymentModel employment = new EmploymentModel();
		model.addAttribute("eployment", employment);

		ProfileImageModel profileImage = new ProfileImageModel();
		model.addAttribute("profileImage", profileImage);

		EducationModel education = new EducationModel();
		model.addAttribute("education", education);

		ITSkillsModel itSkills = new ITSkillsModel();
		model.addAttribute("itSkills", itSkills);

		KeySkillsModel keySkills = new KeySkillsModel();
		model.addAttribute("keySkills", keySkills);

		ProjectModel project = new ProjectModel();
		model.addAttribute("project", project);

		ResumeHeadlineModel resumeheadline = new ResumeHeadlineModel();
		model.addAttribute("resumeheadline", resumeheadline);

		return "resume";
	}

	@PostMapping("/profile")
	public String submitForm(HttpServletRequest request, @ModelAttribute ProfileDetails profileDetails, Model model) {

		// TODO: Profile Details and using the retrieved data and Save Data to updating

		String name = request.getParameter("name");
		String totalExperience = request.getParameter("totalExperience");
		String currentLocation = request.getParameter("currentLocation");
		String mobileNumber = request.getParameter("mobileNumber");
		String emailAddress = request.getParameter("emailAddress");

		ProfileDetails profile = new ProfileDetails();

		profile.setName(name);
		profile.setCurrentLocation(currentLocation);
		profile.setMobileNumber(mobileNumber);
		profile.setEmailAddress(emailAddress);
		profile.setTotalExperience(totalExperience);

		model.addAttribute("profile", profile);
		detailsService.saveListItem(profileDetails);

		return "redirect:/home/form";
	}

	@PostMapping("/eployment")
	public String submitForm(HttpServletRequest request, Model model, @ModelAttribute EmploymentModel employmentModel) {
		// TODO: Employment Model and using the retrieved data and Save Data to updating
		String employmentType = request.getParameter("employmentType");
		String totalexperience = request.getParameter("totalExperience");
		String companyName = request.getParameter("companyName");
		String designation = request.getParameter("designation");
		String joiningDate = request.getParameter("joiningDate");
		String workedTill = request.getParameter("workedTill");
		String jobProfile = request.getParameter("jobProfile");

		EmploymentModel eployment = new EmploymentModel();

		eployment.setEmploymentType(employmentType);
		eployment.setTotalExperience(totalexperience);
		eployment.setCompanyName(companyName);
		eployment.setDesignation(designation);
		eployment.setJoiningDate(joiningDate);
		eployment.setWorkedTill(workedTill);
		eployment.setJobProfile(jobProfile);

		model.addAttribute("eployment", eployment);
		employmentService.saveAllFile(employmentModel);
		return "redirect:/home/form";
	}

	@PostMapping("/education")
	public String submitForm(HttpServletRequest request, Model model, @ModelAttribute EducationModel educationModel) {

		// TODO: EducationModel and using the retrieved data and Save Data to updating
		String title = request.getParameter("title");
		String collage = request.getParameter("collage");
		String location = request.getParameter("location");
		String course = request.getParameter("course");
		String description = request.getParameter("description");

		EducationModel education = new EducationModel();

		education.setTitle(title);
		education.setCollage(collage);
		education.setLocation(location);
		education.setCourse(course);
		education.setDescription(description);

		model.addAttribute("education", education);
		educationService.saveAllFile(educationModel);
		return "redirect:/home/form";
	}

	@PostMapping("/image")
	public String submitForm(@RequestParam("profileimagemodel") MultipartFile imageFile) throws IOException {

		// TODO: Profile Image Model and using the retrieved data and Save Data to
		// updating
		ProfileImageModel profileImage = new ProfileImageModel();
		profileImage.setImage(imageFile.getBytes());
		profileImageService.saveDatabases(profileImage);
		return "redirect:/home/form";
	}

	@PostMapping("/project")
	public String submitForm(HttpServletRequest request, Model model, @ModelAttribute ProjectModel projectModel) {

		// TODO: ProjectModel and using the retrieved data and Save Data to updating
		String proejectTitle = request.getParameter("proejectTitle");
		String workedTime = request.getParameter("workedTime");
		String workedFrom = request.getParameter("workedFrom");
		String detailsOfroject = request.getParameter("detailsOfroject");

		ProjectModel project = new ProjectModel();
		project.setProejectTitle(proejectTitle);
		project.setWorkedTime(workedTime);
		project.setWorkedFrom(workedFrom);
		project.setDetailsOfroject(detailsOfroject);
		model.addAttribute("project", project);

		projectService.saveFile(projectModel);
		return "redirect:/home/form";
	}

	@PostMapping("/headline")
	public String submitForm(HttpServletRequest request, Model model,
			@ModelAttribute ResumeHeadlineModel headlineModel) {

		// TODO: ResumeHeadlineModel and using the retrieved data and Save Data to
		// updating

		String headline = request.getParameter("headline");

		ResumeHeadlineModel resumeheadline = new ResumeHeadlineModel();
		resumeheadline.setHeadline(headline);

		model.addAttribute("resumeheadline", resumeheadline);
		resumeHedlineService.saveAllFiles(headlineModel);

		return "redirect:/home/form";
	}

	@PostMapping("/itSkills")
	public String submitForm(HttpServletRequest request, Model model, @ModelAttribute ITSkillsModel itSkillsModel) {

		// TODO: ITSkillsModel and using the retrieved data and Save Data to updating
		String skills = request.getParameter("skills");
		String version = request.getParameter("version");
		String lastused = request.getParameter("lastused");
		String experience = request.getParameter("experience");

		ITSkillsModel itSkills = new ITSkillsModel();

		itSkills.setSkills(skills);
		itSkills.setVersion(version);
		itSkills.setLastused(lastused);
		itSkills.setExperience(experience);

		model.addAttribute("itSkills", itSkills);
		itSkillsService.saveFile(itSkillsModel);

		return "redirect:/home/form";
	}

	@PostMapping("/keySkills")
	public String submitForm(HttpServletRequest request, Model model, @ModelAttribute KeySkillsModel keySkillsModel) {
		// TODO: KeySkillsModel and using the retrieved data and Save Data to updating
		String skill = request.getParameter("skill");

		KeySkillsModel keySkills = new KeySkillsModel();
		keySkills.setSkill(skill);

		model.addAttribute("keySkills", keySkills);
		keySkillService.saveAllFile(keySkillsModel);

		return "redirect:/home/form";
	}
}
