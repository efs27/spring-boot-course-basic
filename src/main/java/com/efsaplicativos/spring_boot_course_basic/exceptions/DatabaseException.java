package com.efsaplicativos.spring_boot_course_basic.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message) {
        super(message);
    }
}
