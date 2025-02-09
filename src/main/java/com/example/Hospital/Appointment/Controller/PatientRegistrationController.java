package com.example.Hospital.Appointment.Controller;

import com.example.Hospital.Appointment.Controller.Dto.PatientRegistrationDto;
import com.example.Hospital.Appointment.Service.PatientUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registration")
public class PatientRegistrationController {

    //using Constructor injection
    private final PatientUserService patientUserService;
    public PatientRegistrationController(PatientUserService patientUserService) {
        this.patientUserService = patientUserService;
    }

    //Handle method to show form
    @GetMapping
    public String showRegistrationForm(Model model){
        model.addAttribute("PatientUser",new PatientRegistrationDto());
        return "registration";
    }

    //Handle method to show ModelAttribute
    @PostMapping
    public String UserRegisterAccount(@ModelAttribute("PatientUser")PatientRegistrationDto patientRegistrationDto, RedirectAttributes redirectAttributes){
        patientUserService.save(patientRegistrationDto);
        redirectAttributes.addFlashAttribute("successMessage", "Registration successful," +
                "Click login to Continue!");
        return "redirect:/registration?success";
    }
}
