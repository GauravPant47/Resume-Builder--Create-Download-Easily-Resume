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

import net.resume.building.model.EmploymentModel;
import net.resume.building.model.ProfileDetails;
import net.resume.building.service.EmploymentService;

@Controller
@RequestMapping("/home")
public class EmploymentController {

    @Autowired
    private EmploymentService employmentService;
    
    @GetMapping("/resume/eployment")
    public String createNewForm(HttpServletRequest request,Model model){
    	
    	String employmentType = request.getParameter("employmentType");
        String totalExperience = request.getParameter("totalExperience");
        String companyName = request.getParameter("companyName");
        String designation = request.getParameter("designation");
        String joiningDate = request.getParameter("joiningDate");
        String workedTill = request.getParameter("workedTill");
        String jobProfile = request.getParameter("jobProfile");
        String companyLocation = request.getParameter("companyLocation");

    	EmploymentModel employments = new EmploymentModel();
        
    	employments.setCompanyLocation(companyLocation);
    	employments.setCompanyName(companyName);
    	employments.setDesignation(designation);
    	employments.setEmploymentType(employmentType);
    	employments.setJobProfile(jobProfile);
    	employments.setJoiningDate(joiningDate);
    	employments.setTotalExperience(totalExperience);
    	employments.setWorkedTill(workedTill);
    	

    	model.addAttribute("employments", employments);
    	
    	return "employments_post";
    }


    @PostMapping("/resume/eployment")
    public String submitForm(@ModelAttribute EmploymentModel employmentModel) {
        // TODO: Employment Model and using the retrieved data and Save Data to updating
        

        employmentService.saveAllFile(employmentModel);
        return "redirect:/home/resume";
    }

}
