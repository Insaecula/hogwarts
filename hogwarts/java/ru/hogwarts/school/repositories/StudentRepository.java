package ru.hogwarts.school.repositories;


import com.example.hogwarts.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);
    List<Student> findByAgeBetween(int min, int max);
    @Query("SELECT COUNT(s) FROM Student s")
    long getTotalStudents();


    @Query("SELECT AVG(s.age) FROM Student s")
    Double getAverageAge();


    @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> findLastFiveStudents();
}