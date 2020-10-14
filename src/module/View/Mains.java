package module.View;

import module.Model.User;
import module.business.ManagementPatient;
import module.business.ManagementUser;

import java.io.*;
import java.util.Scanner;


public class Mains implements Serializable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagementUser managementUser = new ManagementUser();
        ManagementPatient management = new ManagementPatient();
        int cases = 0;
        do {
            System.out.println("1: Đăng Nhập ");
            System.out.println("2: Đăng Ký ");
            System.out.println("3: exit");
            try {
                management.readFile();
                management.writeToFile();
                managementUser.writeToFile();
                cases = Integer.parseInt(sc.nextLine());
                switch (cases) {
                    case 1:
                        User user = managementUser.checkUser();
                        if (user.getRole() == 0) {
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
                                            management.search();
                                            break;
                                        case 2:
                                            management.show();
                                            break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Chọn lại số đi ");
                                }
                            } while (n != 3);
                            break;
                        } else if (user.getRole() == 1) {
                            int n = 0;
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
                                            management.search();
                                            break;
                                        case 3:
                                            management.edit();
                                            break;
                                        case 4:
                                            management.delete();
                                            break;
                                        case 5:
                                            management.show();
                                            break;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Nhập số");
                                }
                            } while (n != 6);
                        }
                        break;
                    case 2:
                        managementUser.addInfos();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập Lại Đê Bạn Ê ");
            }
        } while (cases != 3);
    }
}
