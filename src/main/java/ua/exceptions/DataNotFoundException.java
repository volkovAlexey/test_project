package ua.exceptions;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String massage) {
        super(massage);
    }
}
