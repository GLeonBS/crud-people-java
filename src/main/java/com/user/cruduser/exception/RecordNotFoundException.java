package com.user.cruduser.exception;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException {
    
    public RecordNotFoundException(UUID id) {
        super("Record not Found, " + id);
    }
    
}
