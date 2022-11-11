package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("add")
    public String index (Model model) {
        model.addAttribute("title", "All Emlployers");
        model.addAttribute("skill", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("skill", skillRepository.findAll());
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "skills/add";
        }

        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewSkill(Model model, @PathVariable int skills) {

        Optional optSkill = skillRepository.findById(skills);
        if (optSkill.isPresent()) {
            Employer employer = (Employer) optSkill.get();
            model.addAttribute("skill", skills);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }



}


