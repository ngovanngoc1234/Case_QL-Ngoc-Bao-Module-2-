package module.managemenboss;
import module.Module.Inpatient;
import module.Module.Outpatients;
import module.Module.Patient;
import module.Module.TransferPatient;
import module.interfaceboss.InterfacePatient;

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
        System.out.println("Nhập Thông Tin Bệnh Nhân : ");
        System.out.println("1 : Bệnh Nhân Ngoại Trú ");
        System.out.println("2 : Bệnh Nhân Chuyển Viện ");
        System.out.println("3 : Bệnh Nhân Nội Trú ");
        switch (inputMenu()) {
            case 1:
                System.out.println("New Enter Information");
                outpatients.addInfo();
                mt.getPatientList().add(outpatients);
                break;
            case 2:
                System.out.println("New Enter Information");
                transferPatient.addInfo();
                mt.getPatientList().add(transferPatient);
                break;
            case 3:
                System.out.println("New Enter Information");
                inpatient.addInfo();
                mt.getPatientList().add(inpatient);
                break;
        }
    }

    @Override
    public void show() throws IOException, ClassNotFoundException {
        writeToFile();
        readFile();
        mt.getPatientList().sort(new SortPatientByName());
        System.out.println("Hiện Thị Theo Thông Tin :");
        System.out.println("1 : Bệnh Nhân Ngoại Trú ");
        System.out.println("2 : Bệnh Nhân Chuyển Viện ");
        System.out.println("3 : Bệnh Nhân Nội Trú ");
        System.out.println("4 : Toàn Bộ Bệnh Nhân ");
        switch (inputMenu()) {
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
    }

    @Override
    public void search(String regex) {
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
            System.out.println("This name is not on the list ");
        }
    }

    @Override
    public void edit(int number) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tên Cần Chỉnh :");
        String edit;
        switch (number) {
            case 1:
                edit = sc.nextLine();
                for (Patient name : mt.getPatientList()) {
                    if (edit.equals(name.getFullName())) {
                        System.out.println("Chỉnh tên : ");
                        String add = sc.nextLine();
                        name.setFullName(add);
                        System.out.println("Name after editing " + name.getFullName());
                    }
                }
                break;

            case 2:
                edit = sc.nextLine();
                for (Patient Diagnosis : mt.getPatientList()) {
                    if (edit.equals(Diagnosis.getFullName())) {
                        System.out.println("Chuẩn Đoán Lại : ");
                        String add = sc.nextLine();
                        Diagnosis.setDiagnosis(add);
                        System.out.println("Name after editing " + Diagnosis.getDiagnosis());
                    }
                }
                break;

            case 3:
                edit = sc.nextLine();
                for (Patient insuranceBook : mt.getPatientList()) {
                    Outpatients bnt = (Outpatients) insuranceBook;
                    if (edit.equals(bnt.getFullName())) {
                        System.out.println("Chỉnh Số Sổ Bảo Hiểm : ");
                        String add = sc.nextLine();
                        bnt.setInsuranceBook(add);
                        System.out.println("Sau khi chỉnh : " + bnt.getInsuranceBook());
                    }
                }
                break;

            case 4:
                edit = sc.nextLine();
                for (Patient facultyName : mt.getPatientList()) {
                    Inpatient bnt = (Inpatient) facultyName;
                    if (edit.equals(bnt.getFullName())) {
                        System.out.println("Chỉnh Tên Khoa : ");
                        String add = sc.nextLine();
                        bnt.setFacultyName(add);
                        System.out.println("Sau khi chỉnh : " + bnt.getFacultyName());
                    }
                }
                break;
        }
    }

    @Override
    public void delete(String id) {
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
            System.out.printf("id = %d not existed.\n", id);
        }
    }

    public int inputMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int id = Integer.parseInt(scanner.nextLine());
                return id;
            } catch (NumberFormatException | NullPointerException ex) {
                System.out.print("Chọn Chức Năng Đê Bạn Ê ");
            }
        }
    }
}
