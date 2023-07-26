package net.resume.building.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.ProfileDetails;
import net.resume.building.model.ProjectModel;
import net.resume.building.service.ProjectService;

@Controller
@RequestMapping("/home")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/resume/project")
	public String createNewForm(HttpServletRequest request, Model model) {

		String proejectTitle = request.getParameter("proejectTitle");
		String workedTime = request.getParameter("workedTime");
		String workedFrom = request.getParameter("workedFrom");
		String detailsOfroject = request.getParameter("detailsOfroject");

		ProjectModel projects = new ProjectModel();

		projects.setProejectTitle(proejectTitle);
		projects.setWorkedFrom(workedFrom);
		projects.setWorkedTime(workedTime);
		projects.setDetailsOfroject(detailsOfroject);

		model.addAttribute("projects", projects);

		return "projects_post";
	}

	@PostMapping("/resume/project")
	public String submitForm(@ModelAttribute ProjectModel projectModel) {

		projectService.saveFile(projectModel);
		return "redirect:/home/resume";
	}
}
