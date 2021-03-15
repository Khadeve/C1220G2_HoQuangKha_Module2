package furamaResort.commons.exception;

import java.io.IOException;

public class InvalidBirthdayException extends IOException {
    public InvalidBirthdayException(){
    }

    public InvalidBirthdayException(String gripe) {
        super(gripe);
    }
}
