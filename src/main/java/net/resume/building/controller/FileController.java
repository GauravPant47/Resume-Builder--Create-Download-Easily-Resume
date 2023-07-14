package net.resume.building.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping("/form")
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

		return "form";
	}

	@PostMapping("/submit")
	public String submitForm(HttpServletRequest request, @ModelAttribute ProfileDetails profileDetails,
			@ModelAttribute EmploymentModel employmentModel, @ModelAttribute ProfileImageModel imageModel,
			@ModelAttribute KeySkillsModel keySkillsModel, @ModelAttribute ITSkillsModel itSkillsModel,
			@ModelAttribute ResumeHeadlineModel headlineModel, @ModelAttribute ProjectModel projectModel,
			@ModelAttribute EducationModel educationModel, Model model) {

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

		// TODO: Profile Image Model
		ProfileImageModel profileImage = new ProfileImageModel();
		profileImage.setImage(imageModel.getImage());

		// TODO: EducationModel
		String title = request.getParameter("title");
		String collage = request.getParameter("collage");
		String location = request.getParameter("location");
		String course = request.getParameter("course");
		String description = request.getParameter("description");

		// TODO: ITSkillsModel
		String skills = request.getParameter("skills");
		String version = request.getParameter("version");
		String lastused = request.getParameter("lastused");
		String itexperience = request.getParameter("experience");

		// TODO: KeySkillsModel
		String skill = request.getParameter("skill");

		// TODO: ProjectModel
		String proejectTitle = request.getParameter("proejectTitle");
		String workedTime = request.getParameter("workedTime");
		String workedFrom = request.getParameter("workedFrom");
		String detailsOfroject = request.getParameter("detailsOfroject");

		// TODO: ResumeHeadlineModel
		String headline = request.getParameter("headline");

		// TODO: Create instances of Profile, Employment, and using the retrieved data

		ProfileDetails profile = new ProfileDetails();

		profile.setName(name);
		profile.setCurrentLocation(currentLocation);
		profile.setMobileNumber(mobileNumber);
		profile.setEmailAddress(emailAddress);
		profile.setTotalExperience(totalExperience);

		EmploymentModel eployment = new EmploymentModel();

		eployment.setEmploymentType(employmentType);
		eployment.setTotalExperience(experience);
		eployment.setCompanyName(companyName);
		eployment.setDesignation(designation);
		eployment.setJoiningDate(joiningDate);
		eployment.setWorkedTill(workedTill);
		eployment.setJobProfile(jobProfile);

		EducationModel education = new EducationModel();
		education.setTitle(title);
		education.setCollage(collage);
		education.setLocation(location);
		education.setCourse(course);
		education.setDescription(description);

		ITSkillsModel itSkills = new ITSkillsModel();
		itSkills.setSkills(skills);
		itSkills.setVersion(version);
		itSkills.setLastused(lastused);
		itSkills.setExperience(itexperience);

		KeySkillsModel keySkills = new KeySkillsModel();
		keySkills.setSkill(skill);

		ProjectModel project = new ProjectModel();
		project.setProejectTitle(proejectTitle);
		project.setWorkedTime(workedTime);
		project.setWorkedFrom(workedFrom);
		project.setDetailsOfroject(detailsOfroject);

		ResumeHeadlineModel resumeheadline = new ResumeHeadlineModel();
		resumeheadline.setHeadline(headline);
		// TODO:
		model.addAttribute("profile", profile);
		model.addAttribute("eployment", eployment);
		model.addAttribute("profileImage", profileImage);
		model.addAttribute("education", education);
		model.addAttribute("itSkills", itSkills);
		model.addAttribute("resumeheadline", resumeheadline);
		model.addAttribute("project", project);
		model.addAttribute("keySkills", keySkills);

		// TODO: Save Data to updating

		profileImageService.saveDatabases(imageModel);

		detailsService.saveListItem(profileDetails);

		employmentService.saveAllFile(employmentModel);

		resumeHedlineService.saveAllFiles(headlineModel);

		projectService.saveFile(projectModel);

		educationService.saveAllFile(educationModel);

		itSkillsService.saveFile(itSkillsModel);

		keySkillService.saveAllFile(keySkillsModel);

		return "redirect:/home/form";
	}
}
