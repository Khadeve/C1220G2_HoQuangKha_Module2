package furamaResort.commons.exception;

import java.io.IOException;

public class InvalidIdCardException extends IOException {
    public InvalidIdCardException() {
    }

    public InvalidIdCardException(String gripe) {
        super(gripe);
    }
}
