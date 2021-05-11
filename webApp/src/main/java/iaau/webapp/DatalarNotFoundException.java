package iaau.webapp;


public class DatalarNotFoundException extends RuntimeException {
    public DatalarNotFoundException(Integer id) {
        super("Could not find the student information of id: " + id);
    }
}
