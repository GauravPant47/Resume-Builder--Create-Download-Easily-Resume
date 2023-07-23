package net.resume.building.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	private ProfileImageModel previousImage;
	private ResumeHeadlineModel previousHeadlineModel;

	@GetMapping("/resume")
	public String showForm(Model model) {

		List<ProfileDetails> profile = detailsService.getAllFiles();
		if (profile != null) {
			model.addAttribute("profile", profile);
		}

		List<EmploymentModel> employments = employmentService.getAllfile();
		model.addAttribute("employments", employments);

		// List<ProfileImageModel> profileImage = profileImageService.getAllFile();
		// model.addAttribute("profileImage", profileImage);

		if (previousImage != null) {
			model.addAttribute("image", previousImage.getImage());
		}

		List<EducationModel> educations = educationService.getfiles();
		model.addAttribute("educations", educations);

		List<ITSkillsModel> itSkills = itSkillsService.getFiles();
		model.addAttribute("itSkills", itSkills);

		List<KeySkillsModel> keySkills = keySkillService.getAllFiles();
		model.addAttribute("keySkills", keySkills);

		List<ProjectModel> projects = projectService.getFilesAll();
		model.addAttribute("projects", projects);

		// List<ResumeHeadlineModel> resumeheadline = resumeHedlineService.getAllFile();
		// model.addAttribute("resumeheadline", resumeheadline);

		if (previousHeadlineModel != null) {
			model.addAttribute("headlines", previousHeadlineModel.getHeadline());
		}

		return "resume";
	}

	@PostMapping("/profile")
	public String submitForm(@RequestParam("name") String name, @RequestParam("totalExperience") String totalExperience,
			@RequestParam("currentLocation") String currentLocation, @RequestParam("mobileNumber") String mobileNumber,
			@RequestParam("emailAddress") String emailAddress) {

		ProfileDetails profile = new ProfileDetails();
		profile.getName();
		profile.getEmailAddress();
		profile.getCurrentLocation();
		profile.getMobileNumber();
		profile.getTotalExperience();

		// model.addAttribute("profile", profile);
		detailsService.saveListItem(profile);
		return "redirect:/home/resume";
	}

	@PostMapping("/eployment")
	public String submitForm(Model model, @ModelAttribute EmploymentModel employmentModel) {
		// TODO: Employment Model and using the retrieved data and Save Data to updating

		employmentService.saveAllFile(employmentModel);
		return "redirect:/home/resume";
	}

	@PostMapping("/education")
	public String submitForm(Model model, @ModelAttribute EducationModel educationModel) {

		// TODO: EducationModel and using the retrieved data and Save Data to updating

		educationService.saveAllFile(educationModel);
		return "redirect:/home/resume";
	}
	// This here we can upload a image and show

	@PostMapping("/image")
	public String submitForm(@RequestParam("image") MultipartFile imageFile, Model model) throws IOException {

		// TODO: Profile Image Model and using the retrieved data and Save Data to
		// updating
		ProfileImageModel profileImage = new ProfileImageModel();
		profileImage.setImage(imageFile.getBytes());

		previousImage = profileImage;
		profileImageService.saveDatabases(previousImage);

		return "redirect:/home/resume";
	}

	@GetMapping("/image/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
		Optional<ProfileImageModel> optionalImage = profileImageService.getAllById(id);
		if (optionalImage.isPresent()) {
			ProfileImageModel imageModel = optionalImage.get();

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<>(imageModel.getImage(), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/project")
	public String submitForm(Model model, @ModelAttribute ProjectModel projectModel) {

		projectService.saveFile(projectModel);
		return "redirect:/home/resume";
	}

	@PostMapping("/headline")
	public String submitForm(HttpServletRequest request, Model model,
			@ModelAttribute ResumeHeadlineModel headlineModel) {

		// TODO: ResumeHeadlineModel and using the retrieved data and Save Data to
		// updating

		String headline = request.getParameter("headline");

		ResumeHeadlineModel resumeheadline = new ResumeHeadlineModel();
		resumeheadline.setHeadline(headline);

		previousHeadlineModel = resumeheadline;
		resumeHedlineService.saveAllFiles(previousHeadlineModel);

		return "redirect:/home/resume";
	}

	@PostMapping("/itSkills")
	public String submitForm(Model model, @ModelAttribute ITSkillsModel itSkillsModel) {

		itSkillsService.saveFile(itSkillsModel);

		return "redirect:/home/resume";
	}

	@PostMapping("/keySkills")
	public String submitForm(HttpServletRequest request, Model model) {
		// TODO: KeySkillsModel and using the retrieved data and Save Data to updating
		String skill = request.getParameter("skill");

		KeySkillsModel keySkills = new KeySkillsModel();
		keySkills.setSkill(skill);

		keySkillService.saveAllFile(keySkills);

		return "redirect:/home/resume";
	}
}
