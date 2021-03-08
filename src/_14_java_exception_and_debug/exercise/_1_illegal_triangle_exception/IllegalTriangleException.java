package _14_java_exception_and_debug.exercise._1_illegal_triangle_exception;

import java.io.IOException;

public class IllegalTriangleException extends IOException {
    public IllegalTriangleException() { }

    public IllegalTriangleException(String gripe) {
        super(gripe);
    }
}
