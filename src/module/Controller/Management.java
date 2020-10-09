package module.Controller;
import module.Model.*;
import module.Model.InterfacePatient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Management implements InterfacePatient {
    List<Patient> patients = new ArrayList<>();
    ListPatient mt = new ListPatient(patients);

    @Override
    public List<Patient> readFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("listpatinet.dat");
        ObjectInputStream ojb = new ObjectInputStream(fileInputStream);
        mt.setPatientList((ArrayList<Patient>) (ojb.readObject()));
        ojb.close();
        fileInputStream.close();
        return mt.getPatientList();
    }

    @Override
    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("listpatinet.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(mt.getPatientList());
        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public void addInfos() throws IOException, ClassNotFoundException {
        mt.setPatientList(readFile());
        Outpatients outpatients = new Outpatients();
        TransferPatient transferPatient = new TransferPatient();
        Inpatient inpatient = new Inpatient();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Nhập Thông Tin Bệnh Nhân : ");
            System.out.println("1 : Bệnh Nhân Ngoại Trú ");
            System.out.println("2 : Bệnh Nhân Chuyển Viện ");
            System.out.println("3 : Bệnh Nhân Nội Trú ");
            System.out.println("4 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                switch (n) {
                    case 1:
                        System.out.println("Nhập thông tin mới");
                        outpatients.addInfo();
                        mt.getPatientList().add(outpatients);
                        break;
                    case 2:
                        System.out.println("Nhập thông tin mới");
                        transferPatient.addInfo();
                        mt.getPatientList().add(transferPatient);
                        break;
                    case 3:
                        System.out.println("Nhập thông tin mới");
                        inpatient.addInfo();
                        mt.getPatientList().add(inpatient);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập số vào ");
            }
        } while (n != 4);
    }

    @Override
    public void show() throws IOException, ClassNotFoundException {
        writeToFile();
        readFile();
        mt.getPatientList().sort(new SortPatientByName());
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println(" Hiện Thị Theo Thông Tin :");
            System.out.println("1 : Bệnh Nhân Ngoại Trú ");
            System.out.println("2 : Bệnh Nhân Chuyển Viện ");
            System.out.println("3 : Bệnh Nhân Nội Trú ");
            System.out.println("4 : Toàn Bộ Bệnh Nhân ");
            System.out.println("5 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                switch (n) {
                    case 1:
                        for (Patient bn : mt.getPatientList()) {
                            if (bn instanceof Outpatients) {
                                System.out.println(bn.toString());
                            }
                        }
                        break;

                    case 2:
                        for (Patient bn : mt.getPatientList()) {
                            if (bn instanceof TransferPatient) {
                                System.out.println(bn.toString());
                            }
                        }
                        break;

                    case 3:
                        for (Patient bn : mt.getPatientList()) {
                            if (bn instanceof Inpatient) {
                                System.out.println(bn.toString());
                            }
                        }
                        break;

                    case 4:
                        for (Patient bn : mt.getPatientList()) {
                            System.out.println(bn.toString());
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập số vào ");
            }
        } while (n != 5);
    }

    @Override
    public void search() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("Chọn Chức Năng");
            System.out.println("1 : Tìm");
            System.out.println("2 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập Thông Tin Cần Tìm :");
                    String regex = sc.nextLine();
                    int index = 0;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;
                    for (int i = 0; i < mt.getPatientList().size(); i++) {
                        matcher = pattern.matcher(mt.getPatientList().get(i).getFullName());
                        if (matcher.find()) {
                            System.out.println("STT " + i + " : " + mt.getPatientList().get(i).toString());
                            index++;
                        }
                    }
                    if (index <= 0) {
                        System.out.println("Tên này không có trong danh sách\n ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhâp vào đê ");
            }
        } while (n != 2);
    }

    @Override
    public void edit() {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        do {
            System.out.println("Nhập Thông tin cần sửa ");
            System.out.println("Chọn Chỉnh Sửa Theo ");
            System.out.println("1:Nhập Tên Bệnh Nhân");
            System.out.println("2:Nhập Tên Bệnh Nhân Cần Chỉnh CHuẩn Đoán Bệnh ");
            System.out.println("3:Nhập Tên Bệnh Nhân Cần Chỉnh Số Bảo Hiểm ");
            System.out.println("4:Nhập Tên Bệnh Nhân Cần Chỉnh Tên Khoa ");
            System.out.println("5: Thoát ");
            try {
                num = Integer.parseInt(sc.nextLine());
                String edit;
                int n = 0;
                switch (num) {
                    case 1:
                        System.out.println("Tên Cần Chỉnh :");
                        edit = sc.nextLine();
                        for (Patient name : mt.getPatientList()) {
                            if (edit.equals(name.getFullName())) {
                                System.out.println("Chỉnh tên : ");
                                String add = sc.nextLine();
                                name.setFullName(add);
                                System.out.println("Tên sau khi chỉnh sửa " + name.getFullName());
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên không co trong danh sách");
                            break;
                        }
                        break;

                    case 2:
                        System.out.println("Tên Cần Chỉnh :");
                        edit = sc.nextLine();
                        for (Patient Diagnosis : mt.getPatientList()) {
                            if (edit.equals(Diagnosis.getFullName())) {
                                System.out.println("Chuẩn Đoán Lại : ");
                                String add = sc.nextLine();
                                Diagnosis.setDiagnosis(add);
                                System.out.println("Tên sau khi chỉnh sửa " + Diagnosis.getDiagnosis());
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên không co trong danh sách");
                        }
                        break;

                    case 3:
                        System.out.println("Tên Cần Chỉnh :");
                        edit = sc.nextLine();
                        for (Patient insuranceBook : mt.getPatientList()) {
                            Outpatients bnt = (Outpatients) insuranceBook;
                            if (edit.equals(bnt.getFullName())) {
                                System.out.println("Chỉnh Số Sổ Bảo Hiểm : ");
                                String add = sc.nextLine();
                                bnt.setInsuranceBook(add);
                                System.out.println("Sau khi chỉnh : " + bnt.getInsuranceBook());
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên không co trong danh sách");
                        }
                        break;

                    case 4:
                        System.out.println("Tên Cần Chỉnh :");
                        edit = sc.nextLine();
                        for (Patient facultyName : mt.getPatientList()) {
                            Inpatient bnt = (Inpatient) facultyName;
                            if (edit.equals(bnt.getFullName())) {
                                System.out.println("Chỉnh Tên Khoa : ");
                                String add = sc.nextLine();
                                bnt.setFacultyName(add);
                                System.out.println("Sau khi chỉnh : " + bnt.getFacultyName());
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("tên không co trong danh sách");
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập lại đê ");
            }
        } while (num != 5);
    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("1: Xóa");
            System.out.println("2: Thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập mã bệnh nhân ");
                    String id = sc.nextLine();
                    Patient patient = null;
                    int size = mt.getPatientList().size();
                    for (int i = 0; i < size; i++) {
                        if (mt.getPatientList().get(i).getProfileCode().equals(id)) {
                            patient = mt.getPatientList().get(i);
                            break;
                        }
                    }
                    if (patient != null) {
                        System.out.println("Bệnh Nhân Đã Xóa Tên Là : \n" + patient.getFullName());
                        mt.getPatientList().remove(patient);
                    } else {
                        System.out.println("Không Có Mã Bệnh Nhân Trong Danh Sách");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhập sai rồi");
            }
        } while (n != 2);
    }

}
