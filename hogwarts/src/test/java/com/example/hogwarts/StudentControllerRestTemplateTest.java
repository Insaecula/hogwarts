package test.java.com.example.hogwarts;

import model.Faculty;
import model.Student;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class StudentControllerRestTemplateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateStudent() {
        Student student = new Student();
        student.setName("Harry");
        student.setAge(15);

        ResponseEntity<Student> response = restTemplate.postForEntity("/student", student, Student.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody().getId());
    }

    @Test
    void testGetStudent() {
        Student student = restTemplate.getForObject("/student/1", Student.class);
        assertNotNull(student);
    }

    @Test
    void testGetStudentsByAgeRange() {
        ResponseEntity<Student[]> response = restTemplate.getForEntity("/student/by-age-range?min=10&max=20", Student[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetFacultyOfStudent() {
        ResponseEntity<Faculty> response = restTemplate.getForEntity("/student/1/faculty", Faculty.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}