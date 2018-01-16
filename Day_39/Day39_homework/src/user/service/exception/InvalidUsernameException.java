package user.service.exception;

public class InvalidUsernameException extends LoginException{

    public static String getInstance() {
        return "用户名错误";
    }


}
