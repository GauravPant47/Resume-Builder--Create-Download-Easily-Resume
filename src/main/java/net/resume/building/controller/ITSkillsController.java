package net.resume.building.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.ITSkillsModel;
import net.resume.building.service.ITSkillsService;

@Controller
@RequestMapping("/home")
public class ITSkillsController {

    @Autowired
    private ITSkillsService itSkillsService;
    
    @PostMapping("/itSkills")
    public String submitForm(HttpServletRequest request, @ModelAttribute ITSkillsModel itSkillsModel) {

        String skills = request.getParameter("skills");
        String version = request.getParameter("version");
        String lastused = request.getParameter("lastused");
        String experience = request.getParameter("experience");

        itSkillsModel.setSkills(skills);
        itSkillsModel.setVersion(version);
        itSkillsModel.setLastused(lastused);
        itSkillsModel.setExperience(experience);

        itSkillsService.saveFile(itSkillsModel);

        return "redirect:/home/resume";
    }

}
