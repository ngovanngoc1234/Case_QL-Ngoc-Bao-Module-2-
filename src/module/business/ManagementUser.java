package module.business;

import module.Model.ListUsers;
import module.display.DisplayUser;
import module.Model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagementUser implements DisplayUser {
    List<User> users = new ArrayList<>();
    ListUsers methodUsers = new ListUsers(users);
    Scanner sc = new Scanner(System.in);


    @Override
    public List<User> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("listuser.dat");
        ObjectInputStream ojb = new ObjectInputStream(fileInputStream);
        methodUsers.setUserList((ArrayList<User>) (ojb.readObject()));
        ojb.close();
        fileInputStream.close();
        return methodUsers.getUserList();
    }


    @Override
    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("listuser.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(methodUsers.getUserList());
        objectOutputStream.close();
        fileOutputStream.close();
    }


    public User checkUser() throws IOException, ClassNotFoundException {
        methodUsers.setUserList(readFile());
        writeToFile();
        User user = null;
        User user1 = new User("admin", "ngoc", User.ADMIN_ROLE);
        User users = new User("user", "ngovanngoc", User.USER_ROLE);
        methodUsers.getUserList().add(user1);
        methodUsers.getUserList().add(users);
            try {
                System.out.println("-----Thông Tin Đăng Nhập-----");
                    System.out.println("Tên tài khoản");
                    String name = sc.nextLine();
                    System.out.println("Mật khẩu");
                    String passWord = sc.nextLine();
                    for (User user5 : methodUsers.getUserList()) {
                        if (name.equals(user5.getYouName()) && passWord.equals(user5.getPassword())) {
                            System.out.println("----Đăng Nhập Thành Công----");
                            return user = user5;
                        }
                    }
                    System.out.println("Sai tài khoản hoặc mật khẩu");
            } catch (Exception e) {
                System.out.println("Nhập vào đê ");
            }
        return null;
    }


    @Override
    public void addInfos() throws IOException, ClassNotFoundException {
        //doc file gan vao bien list user
        methodUsers.setUserList(readFile());
        int number = 0;
        do {
            System.out.println("1: Thêm tài khoản mới");
            System.out.println("2: Thoát ");
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number == 1) {
                    User user = new User();
                    System.out.println("Mời Nhập Thông Tin ");
                    user.createAccount();
                    int index = 0;
                    for (User value : methodUsers.getUserList()) {
                        if (user.getYouName().equals(value.getYouName())) {
                            index++;
                        }
                    }
                    if (index == 0) {
                        methodUsers.getUserList().add(user);
                        System.out.println("Thêm thành công ");
                    } else {
                        System.out.println("Tài khoản đã tồn tại");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhập vào đi");
            }
        } while (number != 2);
        //ghi vao file
    }


    @Override
    public void show() throws IOException, ClassNotFoundException {

    }

    @Override
    public void search() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }


}
