package by.fpmibsu.OnlineMarketplace.validation;

import by.fpmibsu.OnlineMarketplace.DAO.UserDao;
import by.fpmibsu.OnlineMarketplace.entity.User;

public class RegisterUserValidator implements Validator<User>{
    private static final  RegisterUserValidator INSTANCE = new RegisterUserValidator();
    @Override
    public ValidationResult isValid(User object) {
        var validationResult = new ValidationResult();
        if(object.getName_() == null || object.getRole_() == null || object.getSurname_() == null || object.getPassword_() == null || object.getLogin_() == null){
            validationResult.add(CustomError.of("invalid parameter", "all fields must be filled"));
        }
        return validationResult;
    }
    public static RegisterUserValidator getInstance(){
        return INSTANCE;
    }
}
