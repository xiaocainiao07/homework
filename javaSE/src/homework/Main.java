package homework;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int Weather=1;
    private static final int Attributively=2;
    private static final int Game=3;
    private static final int Grade=4;

    Tools tools=new Tools();

    public static void main(String[] args) throws IOException, DocumentException {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("1.注册 2.登录");
            int choice = input.nextInt();
            switch (choice) {
                case 1:

                    input.nextLine();
                    System.out.println("请输入姓名");
                    String name = input.nextLine();
                    System.out.println("请输入用户名");
                    String username = input.nextLine();
                    Tools tools = null;
                    try {
                        tools = new Tools();
                        tools.isMobileNO = username;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        tools.isEmailNO = username;
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        return;
                    }
                    System.out.println("请输入密码");
                    String password = input.nextLine();
                    System.out.println("注册成功");

                    System.out.println(Arrays.toString(UserData.users.toArray()));
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("请输入用户名：");
                    String username1 = input.nextLine();
                    System.out.println("请输入密码：");
                    String password1 = input.nextLine();
                    UserOperate.login(username1, password1);
                    break;
            }
        }


        while (true) {
            int choice=input.nextInt();

            switch (choice) {
                case Weather:
                    input.nextLine();
                    System.out.println("1.查询天气");
                    String weather=  input.nextLine();
                    break;
                case Attributively:
                    System.out.println("2.查询手机号归属地");

                    break;
                case Game:
                    System.out.println("3.手速游戏");

                    break;
                case Grade:
                    System.out.println("4.查询手速游戏前十用户");

                    break;

            }


        }
    }
}