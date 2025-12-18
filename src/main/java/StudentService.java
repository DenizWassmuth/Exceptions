import java.util.List;
import java.util.UUID;

public class StudentService {

    private final StudentRepo repo = new StudentRepo();

    public Student addNewStudent(Student newStudent) {
        Student studentToSave = newStudent.withId(UUID.randomUUID().toString());
        return repo.save(studentToSave);
    }

    public List<Student> getAllStudents(){
        return repo.getAllStudents();
    }

    public Student getStudentById(String id) throws InvalidIdException, Exception {

        if (repo.getAllStudents().isEmpty()){
            throw new Exception("Student repo is empty!");
        }

        for (Student student : repo.getAllStudents()){
            if (student.id().equals(id)){
                return student;
            }
        }

        throw new InvalidIdException("Student not found in repo!");
    }

    public List<String> getAllStudentIds(){

        if (repo.getAllStudents().isEmpty()){
            return null;
        }

        return repo.getAllStudents().stream().map(Student::id).toList();
    }
}
