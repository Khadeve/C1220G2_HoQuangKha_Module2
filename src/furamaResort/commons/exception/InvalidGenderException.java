package furamaResort.commons.exception;

import java.io.IOException;

public class InvalidGenderException extends IOException {
    public InvalidGenderException() {}

    public InvalidGenderException(String gripe) {
        super(gripe);
    }
}
