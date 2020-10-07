package module.main;

import module.Module.User;
import module.managemenboss.Management;
import module.managemenboss.ManagementUser;

import java.io.*;
import java.util.Scanner;


public class Mains implements Serializable {
    public static void main(String[] args) {
        ManagementUser managementUser = new ManagementUser();
        Management management = new Management();
        Scanner sc = new Scanner(System.in);

        do {
            try {
                management.readFile();
                management.writeToFile();
                managementUser.addInfos();
                System.out.println("Please log in");
                System.out.println("User name");
                String ad = sc.nextLine();
                System.out.println("Password");
                String adMk = sc.nextLine();
                User user = managementUser.checkUser(ad, adMk);
                String search;
                if (user.getRole() == 0) {
                    System.out.println("----Logged in successfully----");
                    int n = 0;
                    do {
                        System.out.println("----Lựa Chọn Chức Năng----");
                        System.out.println("1: Tìm Kiếm Bệnh Nhân : ");
                        System.out.println("2: Hiển Thị Thông Tin Bệnh Nhân :");
                        System.out.println("3: Exit :");
                        try {
                            n = Integer.parseInt(sc.nextLine());
                            switch (n) {
                                case 1:
                                    System.out.println("Nhập Thông Tin Cần Tìm :");
                                    search = sc.nextLine();
                                    management.search(search);
                                    break;
                                case 2:
                                    System.out.println("Thông Tin Bệnh Nhân :");
                                    management.show();
                                    break;
                            }
                        } catch (Exception e){
                            System.out.println("Chọn lại số đi ");
                        }
                    } while (n!= 3);
                } else if (user.getRole() == 1) {
                    System.out.println("----Logged in successfully----");
                    int n = 7;
                    do {
                        System.out.println("  Lựa Chọn Chức Năng :");
                        System.out.println("1: Thêm Bệnh Nhân : ");
                        System.out.println("2: Tìm Kiếm Bệnh Nhân : ");
                        System.out.println("3: Chỉnh Sửa Thông Tin Bệnh Nhân :");
                        System.out.println("4: Xóa Tên Khỏi Hồ Sơ : ");
                        System.out.println("5: Hiển Thị Thông Tin Bệnh Nhân :");
                        System.out.println("6: Thoát :");
                        try {
                            n = Integer.parseInt(sc.nextLine());
                            switch (n) {
                                case 1:
                                    management.addInfos();
                                    break;
                                case 2:
                                    System.out.println("Nhập Tên Cần Tìm ");
                                    search = sc.nextLine();
                                    management.search(search);
                                    break;
                                case 3:
                                    management.edit();
                                    break;
                                case 4:
                                    System.out.println("Nhập Mã Bệnh Nhân Cần xóa :");
                                    management.delete();
                                    break;
                                case 5:
                                    System.out.println("Thông Tin Bệnh Nhân :");
                                    management.show();
                                    break;
                                default:
                                    throw new Exception("Nhập lại đi ngoc");
                            }
                        } catch (Exception e) {
                            System.out.println("Nhập số");
                        }
                    } while (n != 6);
                }
            } catch (Exception e) {
                System.out.println("Nhập Lại Đê Bạn Ê ");
            }
        } while (true);
    }
}
