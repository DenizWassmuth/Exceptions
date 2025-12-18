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

    public Student getStudentById(String id) {

        if (repo.getAllStudents().isEmpty()){
            throw new RuntimeException("Student repo is empty!");
        }

        for (Student student : repo.getAllStudents()){
            if (student.id().equals(id)){
                return student;
            }
        }

        throw new InvalidIdException();
    }

    public List<String> getAllStudentIds() {

        if (repo.getAllStudents().isEmpty()){

            throw new RuntimeException("student repo is empty");
            //return null;
        }

        return repo.getAllStudents().stream().map(Student::id).toList();
    }
}
