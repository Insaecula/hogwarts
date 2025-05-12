package ru.hogwarts.school.controller;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.List;

public class StudentController {
    @GetMapping("/by-age-range")
    public List<Student> getStudentsByAgeRange(@RequestParam int min, @RequestParam int max) {
        return studentService.findByAgeRange(min, max);
        @GetMapping("/{id}/faculty")
        public Faculty getFacultyOfStudent(@PathVariable Long id){
            return studentService.getFacultyByStudentId(id);
        }
            private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
                this.studentRepository = studentRepository;
            }

            @GetMapping("/count")
            public long getTotalStudents() {
                return studentRepository.getTotalStudents();
            }

            @GetMapping("/average-age")
            public double getAverageAge() {
                return studentRepository.getAverageAge();
            }

            @GetMapping("/last-five")
            public List<Student> getLastFiveStudents() {
                return studentRepository.findLastFiveStudents();
        }
    }
}
