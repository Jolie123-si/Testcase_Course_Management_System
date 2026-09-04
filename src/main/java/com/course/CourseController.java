package com.course;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {

    private CourseService service = new CourseService();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam String code,
                       @RequestParam String name,
                       @RequestParam int credits,
                       @RequestParam int maxStudents,
                       Model model) {
        String result = service.saveCourse(new Course(code, name, credits, maxStudents));
        model.addAttribute("message", result);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam String code, Model model) {
        Course found = service.searchByCourseCode(code);
        model.addAttribute("searchResult", found);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String code, Model model) {
        model.addAttribute("message", service.deleteCourse(code));
        return "index";
    }
}
