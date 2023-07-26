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

import net.resume.building.model.EducationModel;
import net.resume.building.model.ProfileDetails;
import net.resume.building.service.EducationService;

@Controller
@RequestMapping("/home")
public class EducationController {

    @Autowired
    private EducationService educationService;

    
    @GetMapping("/resume/education")
    public String createNewForm(HttpServletRequest request,Model model){
    	String title = request.getParameter("title");
        String collage = request.getParameter("collage");
        String location = request.getParameter("location");
        String course = request.getParameter("course");
        String description = request.getParameter("description");
        // TODO: EducationModel and using the retrieved data and Save Data to updating
    	EducationModel educations = new EducationModel();
        
    	educations.setTitle(title);
    	educations.setCollage(collage);
    	educations.setDescription(description);
    	educations.setLocation(location);
    	educations.setCourse(course);

    	model.addAttribute("educations", educations);
    	
    	return "education_post";
    }


    @PostMapping("/resume/education")
    public String submitForm(@ModelAttribute EducationModel educationModel) {
        

        educationService.saveAllFile(educationModel);
        return "redirect:/home/resume";
    }
}
