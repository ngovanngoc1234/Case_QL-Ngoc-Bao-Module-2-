package module.managemenboss;

import module.Module.ListUsers;
import module.interfaceboss.InterfaceUser;
import module.Module.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementUser implements InterfaceUser {
    List<User> users = new ArrayList<>();
    ListUsers methodUsers = new ListUsers(users);

    public User checkUser(String ad, String adMk) {
        if (ad != null && adMk != null) {
            User user = new User();
            int index = 0;
            for (User user5 : methodUsers.getUserList()) {
                if (ad.equals(user5.getYouName()) && adMk.equals(user5.getPassword())) {
                    user = user5;
                    index++;
                }
            }
            if (index <= 0) {
                return null;
            }
            return user;
        } else {
            return null;
        }
    }

    @Override
    public List<User> readFile() throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    public void addInfos() throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("----Select Information----");
        System.out.println("1: Already have an Account");
        System.out.println("2: Add New Account");
        int number = Integer.parseInt(sc.nextLine());
        User user = new User("admin", "ngoc", User.ADMIN_ROLE);
        User users = new User("user", "ngovanngoc", User.USER_ROLE);
        methodUsers.getUserList().add(user);
        methodUsers.getUserList().add(users);
        switch (number) {
            case 1:
                break;
            case 2:
                User users1 = new User();
                System.out.println("Mời Nhập Thông Tin ");
                users1.createAccount();
                if (users1.getYouName() != null && users1.getPassword() != null) {
                    int index = 0;
                    for (User value : methodUsers.getUserList()) {
                        if (users1.getYouName().equals(value.getYouName())) {
                            index++;
                        }
                    }
                    if (index == 0) {
                        methodUsers.getUserList().add(users1);
                    } else {
                        System.out.println("Account already exists");
                    }
                } else {
                    System.out.println("No Account or Password Enter yet");
                }
                break;
        }
    }

    @Override
    public void show() throws IOException, ClassNotFoundException {

    }

    @Override
    public void search(String regex) {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void writeToFile() throws IOException {

    }
}
