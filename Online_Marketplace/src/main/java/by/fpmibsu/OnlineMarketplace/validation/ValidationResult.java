package by.fpmibsu.OnlineMarketplace.validation;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    @Getter
    private List<CustomError> errors = new ArrayList<>();
    public void add(CustomError error){
        this.errors.add(error);
    }
    public boolean isValid(){
        return errors.isEmpty();
    }
}
