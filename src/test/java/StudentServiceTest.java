import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

//    @Test
//    void addNewStudent() {
//    }
//
//    @Test
//    void getAllStudents() {
//    }


    @Test
    void getStudentById_shouldPass_asStudentRepoIsEmpty() {

        StudentService studentService = new StudentService();
        Student student = studentService.getStudentById("1");

        assertEquals(null, student);
    }

    @Test
    void getStudentById_shouldPass_asStudentRepoIsNotEmpty() {

        StudentService studentService = new StudentService();
        studentService.addNewStudent(new Student("1", "Bob", "Chemistry"));

        String id = studentService.getAllStudentIds().get(0);
        Student student = studentService.getStudentById(id);

        assertNotNull(student);
    }

   // @ParameterizedTest
}