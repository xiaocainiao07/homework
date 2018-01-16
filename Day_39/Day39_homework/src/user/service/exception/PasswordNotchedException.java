package user.service.exception;

public class PasswordNotchedException extends LoginException {
    @Override
       public String getMessage() {
        return "密码错误";
    }
}
