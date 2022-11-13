package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

// Add a field employerRepository annotated with @Autowired
// A user will select an employer when they create a job. --> pass in query parameter
// Add the employer data from employerRepository into the form template
// The add job form already includes an employer selection option (lines 17 - 25).
// Be sure your variable name for the employer data matches that already used in templates/add

// Checkout templates/add.html.
// Make a mental note of the name of the variable being used to pass the selected employer id on form submission
// line 19 --> name="employerId"



/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Jobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("employer", employerRepository.findAll());
        model.addAttribute(new Job());
        return "add";
    }

    // UNDONE: changed int to Integer for employerId to use "==" in if/then statement

    // In processAddJobForm, add code inside of this method
    // SO THAT the CHOSEN employer object
    // BECOMES affiliated with the new job.
    // You will need to select the employer using the request parameter --> employerId
    // this is the loop from the video?
    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model,
                                    @RequestParam int employerId,
                                    @RequestParam List<Integer> skills) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            return "add";
        }
        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("job", newJob);
            return "employers/view";
        }
        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
/*        Optional<Employer> addEmployer = employerRepository.findById(employerId);
        if (addEmployer.isPresent()) {
            model.addAttribute("job", newJob);
        }*/
        return "view";
    }


}
