public class InvalidIdException extends RuntimeException {

    public InvalidIdException(){
        super ("invalid student ID");
    }

    public InvalidIdException(String message) {
        super(message);
    }


}
