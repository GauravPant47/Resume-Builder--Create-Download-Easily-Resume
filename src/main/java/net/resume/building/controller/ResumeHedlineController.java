package net.resume.building.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.ProjectModel;
import net.resume.building.model.ResumeHeadlineModel;
import net.resume.building.service.ResumeHedlineService;

@Controller
@RequestMapping("/home")
public class ResumeHedlineController {

	@Autowired
	private ResumeHedlineService resumeHedlineService;

	@GetMapping("/resume/headline")
	public String createNewForm(HttpServletRequest request, Model model) {
		// TODO: ResumeHeadlineModel and using the retrieved data and Save Data to
		// updating

		String headline = request.getParameter("headline");

		ResumeHeadlineModel resumeheadline = new ResumeHeadlineModel();

		resumeheadline.setHeadline(headline);

		model.addAttribute("resumeheadline", resumeheadline);

		return "headline_post";
	}

	@PostMapping("/resume/headline")
	public String submitForm(@ModelAttribute ResumeHeadlineModel headlineModel) {

		resumeHedlineService.saveAllFiles(headlineModel);

		return "redirect:/home/resume";
	}

}
