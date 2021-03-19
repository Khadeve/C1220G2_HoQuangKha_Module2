package furamaResort.commons.exception;

import java.io.IOException;

public class InvalidEmailException extends IOException {
    public InvalidEmailException() {}

    public InvalidEmailException(String gripe) {
        super(gripe);
    }
}
