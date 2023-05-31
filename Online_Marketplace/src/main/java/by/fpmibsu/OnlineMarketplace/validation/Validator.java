package by.fpmibsu.OnlineMarketplace.validation;

public interface Validator<T> {
    ValidationResult isValid(T object);
}
