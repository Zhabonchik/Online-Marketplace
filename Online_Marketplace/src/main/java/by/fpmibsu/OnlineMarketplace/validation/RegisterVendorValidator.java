package by.fpmibsu.OnlineMarketplace.validation;

import by.fpmibsu.OnlineMarketplace.entity.Vendor;

public class RegisterVendorValidator implements Validator<Vendor>{
    private static final  RegisterVendorValidator INSTANCE = new RegisterVendorValidator();
    @Override
    public ValidationResult isValid(Vendor object) {
        var validationResult = new ValidationResult();
        if(object.getName_() == null || object.getSurname_() == null || object.getPassword_() == null || object.getLogin_() == null){
            validationResult.add(CustomError.of("invalid parameter", "all fields must be filled"));
        }
        return validationResult;
    }
    public static RegisterVendorValidator getInstance(){
        return INSTANCE;
    }
}
