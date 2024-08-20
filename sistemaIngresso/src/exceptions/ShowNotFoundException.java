package exceptions;

public class ShowNotFoundException extends Exception {

    public ShowNotFoundException(String id) {
        super("Show not found for id: " + id); 
    }

}
