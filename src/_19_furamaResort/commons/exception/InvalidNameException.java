package furamaResort.commons.exception;

import java.io.IOException;

public class InvalidNameException extends IOException {

    public InvalidNameException(){};

    public InvalidNameException(String gripe) {
        super(gripe);
    }
}
