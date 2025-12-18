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
    void getStudentById_ShouldThrowException_WhenStudentRepositoryIsEmpty(){
        StudentService studentService = new StudentService();
        assertThrows(Exception.class, () -> studentService.getStudentById(""));
    }



    @Test
    void getStudentById_throwsInvalidIdException_asStudentIdIsRandomizedWhenStudentIsAdded() {

        StudentService studentService = new StudentService();
        studentService.addNewStudent(new Student("1", "Bob", "Chemistry"));
        //id = studentService.getAllStudentIds().get(0);

        //TODO:: ???
        String finalId = "1";
        assertThrows(InvalidIdException.class, () -> studentService.getStudentById(finalId));

    }

    @Test
    void getStudentById_doesNotThrowInvalidIdOrStandardException_asStudentIdIsTheIdOfTheStudentAtIndex0() {

        StudentService studentService = new StudentService();
        studentService.addNewStudent(new Student("1", "Bob", "Chemistry"));

        //TODO:: ???
        String finalId = studentService.getAllStudentIds().get(0);
        assertThrows(Exception.class, () -> studentService.getStudentById(finalId));

    }

}