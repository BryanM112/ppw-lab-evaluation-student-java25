package ec.edu.ups.icc.labevaluation.supplies.exceptions;

import org.springframework.http.HttpStatus;

import ec.edu.ups.icc.labevaluation.core.exceptions.base.ApplicationException;

public class SupplyNotFoundException extends ApplicationException{
    public SupplyNotFoundException(String mensaje){
        super(HttpStatus.NOT_FOUND, "SUPPLY_NOT_FOUND", mensaje);
    }
}
