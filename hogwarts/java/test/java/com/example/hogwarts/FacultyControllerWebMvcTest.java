package test.java.com.example.hogwarts;

import ru.hogwarts.school.controller.FacultyController;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import static javax.swing.UIManager.get;

@WebMvcTest(FacultyController.class)
class FacultyControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FacultyService facultyService;

    @Test
    void testGetFaculty() throws Exception {
        Faculty faculty = new Faculty();
        faculty.setId(1L);
        faculty.setName("Slytherin");

        Mockito.when(facultyService.getFaculty(1L)).thenReturn(faculty);

        mockMvc.perform(get("/faculty/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Slytherin"));
    }

    @Test
    void testFilterFaculty() throws Exception {
        Faculty f = new Faculty();
        f.setName("Hufflepuff");

        Mockito.when(facultyService.findByNameOrColorIgnoreCase("hufflepuff"))
                .thenReturn(List.of(f));

        mockMvc.perform(get("/faculty/filter?value=hufflepuff"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Hufflepuff"));
    }
}