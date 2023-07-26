package net.resume.building.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.EducationModel;
import net.resume.building.model.EmploymentModel;
import net.resume.building.model.ITSkillsModel;
import net.resume.building.model.KeySkillsModel;
import net.resume.building.model.ProfileDetails;
import net.resume.building.model.ProjectModel;
import net.resume.building.model.ResumeHeadlineModel;
import net.resume.building.service.EducationService;
import net.resume.building.service.EmploymentService;
import net.resume.building.service.ITSkillsService;
import net.resume.building.service.KeySkillService;
import net.resume.building.service.ProfileDetailsService;
import net.resume.building.service.ProjectService;
import net.resume.building.service.ResumeHedlineService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private ITSkillsService itSkillsService;

	@Autowired
	private KeySkillService keySkillService;
	
    @Autowired
    private EducationService educationService;

    @Autowired
    private EmploymentService employmentService;
    
    @Autowired
    private ProfileDetailsService detailsService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ResumeHedlineService resumeHedlineService;
    
	@GetMapping
	public String homePage() {
		return "index";
	}


	@GetMapping("/resume")
	public String showForm(Model model) {

        List<ResumeHeadlineModel> resumeheadline = resumeHedlineService.getAllFile();
        model.addAttribute("resumeheadline", resumeheadline);
		
        List<ProjectModel> projects = projectService.getFilesAll();
        model.addAttribute("projects", projects);
		
        List<ProfileDetails> profiles = detailsService.getAllFiles();
        model.addAttribute("profiles", profiles);
		
        List<EmploymentModel> employments = employmentService.getAllfile();
        model.addAttribute("employments", employments);

        List<EducationModel> educations = educationService.getfiles();
        model.addAttribute("educations", educations);
		
		List<KeySkillsModel> keySkills = keySkillService.getAllFiles();
		model.addAttribute("keySkills", keySkills);

		List<ITSkillsModel> itSkills = itSkillsService.getFiles();
		model.addAttribute("itSkills", itSkills);

		return "resume";
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
	
	@GetMapping("/moreResumes")
	public String allResumes() {
		return "moreResumes";
	}
	
}
