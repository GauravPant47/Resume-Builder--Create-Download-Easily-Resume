package net.resume.building.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.ResumeHeadlineModel;
import net.resume.building.service.ResumeHedlineService;

@Controller
@RequestMapping("/home")
public class ResumeHedlineController {

    @Autowired
    private ResumeHedlineService resumeHedlineService;


    @PostMapping("/headline")
    public String submitForm(HttpServletRequest request, @ModelAttribute ResumeHeadlineModel headlineModel) {

        // TODO: ResumeHeadlineModel and using the retrieved data and Save Data to
        // updating

        String headline = request.getParameter("headline");
        headlineModel.setHeadline(headline);

        resumeHedlineService.saveAllFiles(headlineModel);

        return "redirect:/home/resume";
    }

}
