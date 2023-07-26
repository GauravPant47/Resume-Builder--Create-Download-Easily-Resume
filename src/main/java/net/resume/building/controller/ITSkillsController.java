package net.resume.building.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.ITSkillsModel;
import net.resume.building.model.ProfileDetails;
import net.resume.building.service.ITSkillsService;

@Controller
@RequestMapping("/home")
public class ITSkillsController {

	@Autowired
	private ITSkillsService itSkillsService;

	@GetMapping("/resume/itSkills")
	public String createNewForm(HttpServletRequest request, Model model) {
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

		return "skill_post";
	}

	@PostMapping("/resume/itSkills")
	public String submitForm(@ModelAttribute ITSkillsModel itSkillsModel) {

		itSkillsService.saveFile(itSkillsModel);

		return "redirect:/home/resume";
	}

}
