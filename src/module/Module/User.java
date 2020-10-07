package module.Module;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String password;
    private String youName;
    public static final int ADMIN_ROLE = 1;
    public static final int USER_ROLE = 0;
    private int role;

    public User() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getYouName() {
        return youName;
    }

    public void setYouName(String youName) {
        this.youName = youName;
    }

    public User(String password, String youName, int role) {
        this.password = password;
        this.youName = youName;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Thông Tin Tài Khoản" + '\'' +
                "Password = '" + password + '\'' +
                "youName = '" + youName + '\'';
    }

    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            System.out.println("Nhập Account ");
            String regexName = "[a-z0-9]{6,12}$";
            String inputName = sc.nextLine();
            Pattern patternName = Pattern.compile(regexName);
            Matcher matcherName = patternName.matcher(inputName);
            if (matcherName.find()) {
                check = true;
                youName = inputName;
            } else {
                System.out.println("Nhập thiếu kìa bạn ơi ");
            }
        } while (!check);
        boolean check1 = false;
        do {
            System.out.println("Nhập password");
            String regexPassword = "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})";
            String inputPassword = sc.nextLine();
            Pattern patternPassword = Pattern.compile(regexPassword);
            Matcher matcherPassword = patternPassword.matcher(inputPassword);
            if (matcherPassword.find()) {
                check1 = true;
                password = inputPassword;
            } else {
                System.out.println("Nhập Lại Đê Bạn Ơi ");
            }
        } while (!check1);
        role = USER_ROLE;
    }
}
