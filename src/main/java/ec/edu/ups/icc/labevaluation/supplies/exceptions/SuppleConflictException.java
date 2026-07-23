package ec.edu.ups.icc.labevaluation.supplies.exceptions;

import org.springframework.http.HttpStatus;

import ec.edu.ups.icc.labevaluation.core.exceptions.base.ApplicationException;

//imitamos la clase que está en core/exceptions/domain/ConflictException.java
public class SuppleConflictException extends ApplicationException{
    public SuppleConflictException(String code, String message) {
        super(HttpStatus.CONFLICT, code, message);
    }
    public SuppleConflictException(String message) {
        this("CONFLICT", message);
    }
}
