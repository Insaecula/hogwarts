package test.java.com.example.hogwarts;

import model.Faculty;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
class FacultyControllerRestTemplateTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateFaculty() {
        Faculty faculty = new Faculty();
        faculty.setName("Gryffindor");
        faculty.setColor("Red");

        ResponseEntity<Faculty> response = restTemplate.postForEntity("/faculty", faculty, Faculty.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody().getId());
    }

    @Test
    void testGetFaculty() {
        Faculty faculty = restTemplate.getForObject("/faculty/1", Faculty.class);
        assertNotNull(faculty);
    }

    @Test
    void testFilterFacultyByNameOrColor() {
        ResponseEntity<Faculty[]> response = restTemplate.getForEntity("/faculty/filter?value=Red", Faculty[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetStudentsOfFaculty() {
        ResponseEntity<Student[]> response = restTemplate.getForEntity("/faculty/1/students", Student[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}