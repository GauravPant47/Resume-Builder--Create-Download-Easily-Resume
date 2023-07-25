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

import net.resume.building.model.ProjectModel;
import net.resume.building.service.ProjectService;

@Controller
@RequestMapping("/home")
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    @PostMapping("/project")
    public String submitForm(HttpServletRequest request, @ModelAttribute ProjectModel projectModel) {
        String proejectTitle = request.getParameter("proejectTitle");
        String workedTime = request.getParameter("workedTime");
        String workedFrom = request.getParameter("workedFrom");
        String detailsOfroject = request.getParameter("detailsOfroject");

        projectModel.setProejectTitle(proejectTitle);
        projectModel.setWorkedFrom(workedFrom);
        projectModel.setWorkedTime(workedTime);
        projectModel.setDetailsOfroject(detailsOfroject);

        projectService.saveFile(projectModel);
        return "redirect:/home/resume";
    }
}
