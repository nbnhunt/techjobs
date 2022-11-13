package org.launchcode.techjobs.persistent.controllers;


import org.launchcode.techjobs.persistent.models.Skill;
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

    @GetMapping("")
    public String index (Model model) {
        model.addAttribute("skills", "All Skills");
        model.addAttribute("skills", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("skills", "All Skills");
            return "skills/add";
        }
        skillRepository.save(newSkill);
        return "redirect:";
    }

    @GetMapping("view/{skills}")
    public String displayViewSkill(Model model, @PathVariable int skill) {

        Optional optSkill = skillRepository.findById(skill);
        if (optSkill.isPresent()) {
            Skill skillsType = (Skill) optSkill.get();
            model.addAttribute("skills", skillsType);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}
