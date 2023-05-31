package by.fpmibsu.OnlineMarketplace.exception;

import by.fpmibsu.OnlineMarketplace.validation.CustomError;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException{
    @Getter
    private final List<CustomError> errors;
    public ValidationException(List<CustomError> errors){
        this.errors = errors;
    }

}
