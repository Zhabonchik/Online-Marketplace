package by.fpmibsu.OnlineMarketplace.exception;

public class MyException extends Exception{
    public String message;

    public MyException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
