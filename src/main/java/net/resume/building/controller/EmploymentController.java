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
import net.resume.building.service.EmploymentService;

@Controller
@RequestMapping("/home")
public class EmploymentController {

    @Autowired
    private EmploymentService employmentService;

    @PostMapping("/eployment")
    public String submitForm(HttpServletRequest request, @ModelAttribute EmploymentModel employmentModel) {
        // TODO: Employment Model and using the retrieved data and Save Data to updating
        String employmentType = request.getParameter("employmentType");
        String totalExperience = request.getParameter("totalExperience");
        String companyName = request.getParameter("companyName");
        String designation = request.getParameter("designation");
        String joiningDate = request.getParameter("joiningDate");
        String workedTill = request.getParameter("workedTill");
        String jobProfile = request.getParameter("jobProfile");
        String companyLocation = request.getParameter("companyLocation");

        employmentModel.setCompanyLocation(companyLocation);
        employmentModel.setCompanyName(companyName);
        employmentModel.setDesignation(designation);
        employmentModel.setEmploymentType(employmentType);
        employmentModel.setJobProfile(jobProfile);
        employmentModel.setJoiningDate(joiningDate);
        employmentModel.setTotalExperience(totalExperience);
        employmentModel.setWorkedTill(workedTill);

        employmentService.saveAllFile(employmentModel);
        return "redirect:/home/resume";
    }

}
