package by.fpmibsu.OnlineMarketplace.validation;

import lombok.Value;

@Value(staticConstructor = "of")
public class CustomError {
    private String code;
    private String message;
}
