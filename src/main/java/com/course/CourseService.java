package com.course;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private List<Course> courses = new ArrayList<>();

    public String saveCourse(Course c) {
        if (c == null) return "provide course data";

        for (Course existing : courses) {
            if (existing.getCourseCode().equalsIgnoreCase(c.getCourseCode()))
                return "course already exists";
        }

        if (c.getCredits() < 1 || c.getCredits() > 5) return "invalid credits";

        courses.add(c);
        return "course saved successfully";
    }

    public Course searchByCourseCode(String code) {
        if (code == null) return null;

        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code))
                return c;
        }
        return null;
    }

    public String deleteCourse(String code) {
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(code)) {
                courses.remove(c);
                return "course deleted";
            }
        }
        return "course not found";
    }
}
