package edu.uc.it.facultydirectory.controller;

import edu.uc.it.facultydirectory.model.Faculty;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
    private final List<Faculty> faculties = new ArrayList<>();

    @PostConstruct
    public void initializeFaculties() {
        faculties.add(new Faculty(1L, "Kelly", "Miller", "Assistant Professor", "Kelly@uc.edu"));
        faculties.add(new Faculty(2L, "Robert", "Lee", "Instructor Educator", "Robert@uc.edu"));
        faculties.add(new Faculty(3L, "Laura", "West", "Adjunct- Professor", "Laura@uc.edu"));
    }

    @GetMapping("/list")
    public String listFaculties(Model model) {
        model.addAttribute("faculties", faculties);
        return "faculty-list";
    }
}
