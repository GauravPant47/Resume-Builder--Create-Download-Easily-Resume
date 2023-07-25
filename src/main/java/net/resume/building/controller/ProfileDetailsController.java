package net.resume.building.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.resume.building.model.ProfileDetails;
import net.resume.building.service.ProfileDetailsService;

@Controller
@RequestMapping("/home")
public class ProfileDetailsController {

    @Autowired
    private ProfileDetailsService detailsService;



    @PostMapping("/profile")
    public String submitForm(HttpServletRequest request,@ModelAttribute ProfileDetails profileDetails){

        String name = request.getParameter("name");
        String totalExperience = request.getParameter("totalExperience");
        String currentLocation = request.getParameter("currentLocation");
        String mobileNumber = request.getParameter("mobileNumber");
        String emailAddress = request.getParameter("emailAddress");

        profileDetails.setName(name);
        profileDetails.setTotalExperience(totalExperience);
        profileDetails.setCurrentLocation(currentLocation);
        profileDetails.setEmailAddress(emailAddress);
        profileDetails.setMobileNumber(mobileNumber);

        // model.addAttribute("profile", profile);
        detailsService.saveListItem(profileDetails);
        return "redirect:/home/resume";
    }

}
