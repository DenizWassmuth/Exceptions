public class Main {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student newStudent = Student.builder()
                .name("Florian")
                .subject("Geschichte")
                .build();

        Student savedStudent = studentService.addNewStudent(newStudent);

        System.out.println();
        System.out.println("Student saved: " + savedStudent);

        try{
           Student firstStudent =  studentService.getStudentById("1");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
