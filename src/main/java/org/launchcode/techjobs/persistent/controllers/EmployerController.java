package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

// re: Chapter 17.3.2: using persistence

// EmployerController contains two handlers with missing information
// .... which are.....?
// Add a private field of EmployerRepository type called employerRepository
// Give this field an @Autowired annotation.

// Add an index method that responds at /employers
// with a list of all employers in the database.
// This method should use the template employers/index.

// processAddEmployerForm doesn’t yet contain the code to save a valid object.
// (it's missing information)
// Use employerRepository and the appropriate method to do so.

@Controller
@RequestMapping("employers")
public class EmployerController {

    // Controllers 1
    @Autowired // dependency injection --> asks Spring Boot for objects named xyz
    private EmployerRepository employerRepository;

    // findAll, save, findById

    // Controllers 2
    @GetMapping("add")
    public String index (Model model) {
        model.addAttribute("title", "All Emlployers");
        model.addAttribute("employer", employerRepository.findAll());
        return "employers/index";
    }


    // Controllers 3
    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("employer", employerRepository.findAll());
        model.addAttribute(new Employer());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "employers/add";
        }

        return "redirect:";
    }

    // Controllers 4
    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
