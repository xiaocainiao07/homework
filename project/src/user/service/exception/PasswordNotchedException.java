package user.service.exception;

public class PasswordNotchedException extends LoginException{
    public String getMessage() {
        return "密码错误";
    }



}
