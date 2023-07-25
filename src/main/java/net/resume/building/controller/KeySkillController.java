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

import net.resume.building.model.KeySkillsModel;
import net.resume.building.service.KeySkillService;

@Controller
@RequestMapping("/home")
public class KeySkillController {

    @Autowired
    private KeySkillService keySkillService;

    @PostMapping("/keySkills")
    public String submitForm(HttpServletRequest request, @ModelAttribute KeySkillsModel keySkills) {
        String skill = request.getParameter("skill");

        keySkills.setSkill(skill);

        keySkillService.saveAllFile(keySkills);

        return "redirect:/home/resume";
    }
}
