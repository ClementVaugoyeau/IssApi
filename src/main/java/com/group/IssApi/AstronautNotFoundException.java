package com.group.IssApi;

public class AstronautNotFoundException extends RuntimeException {

    AstronautNotFoundException(Long id) {
        super("Coud not find astronauts " + id);
    }

    
    
}
