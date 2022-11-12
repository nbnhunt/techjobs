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
        model.addAttribute("title", "All Skills");
        model.addAttribute("skill", skillRepository.findAll());
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model) {
        // model.addAttribute("skill", skillRepository.findAll());
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("index")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                         Errors errors, Model model) {
        model.addAttribute("skills", skillRepository.save(newSkill));
        if (errors.hasErrors()) {
            return "skills/add";
        }

        return "redirect:";
    }

    @GetMapping("view/{skills}")
    public String displayViewSkill(Model model, @PathVariable int skill) {

        Optional optSkill = skillRepository.findById(skill);
        if (optSkill.isPresent()) {
            Skill skillsType = (Skill) optSkill.get();
            model.addAttribute("skill", skillsType);
            return "skills/view";
        } else {
            return "redirect:../";
        }
    }
}
