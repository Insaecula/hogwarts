package controller;

import model.Faculty;
import model.Student;

import java.util.List;

public class StudentController {
    @GetMapping("/by-age-range")
    public List<Student> getStudentsByAgeRange(@RequestParam int min, @RequestParam int max) {
        return studentService.findByAgeRange(min, max);
        @GetMapping("/{id}/faculty")
        public Faculty getFacultyOfStudent(@PathVariable Long id) {
            return studentService.getFacultyByStudentId(id);
        }
    }
}
