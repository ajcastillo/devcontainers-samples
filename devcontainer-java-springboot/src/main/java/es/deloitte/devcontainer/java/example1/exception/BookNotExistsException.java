package es.deloitte.devcontainer.java.example1.exception;

public class BookNotExistsException extends Exception{

    @Override
    public String toString() {
        return "BookNotExistsException []";
    }
    
}