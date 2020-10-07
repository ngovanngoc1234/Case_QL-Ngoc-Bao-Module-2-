package module.Module;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patient implements Serializable {
    private String profileCode;
    private String fullName;
    private String dateOfBirth;
    private String diagnosis;

    public String getProfileCode() {
        return profileCode;
    }

    public void setProfileCode(String profileCode) {
        this.profileCode = profileCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Patient() {
    }

    public Patient(String profileCode, String fullName, String dateOfBirth, String diagnosis) {
        this.profileCode = profileCode;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return  " Mã hồ sơ : "+profileCode + '\'' +
                ", Họ Tên : " + fullName + '\'' +
                ", Ngày Tháng Năm Sinh : " +  dateOfBirth+ '\'' +
                ", Chuẩn Đoán : " + diagnosis + '\'';
    }

    public void addInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Mã Hồ Sơ  :");
        profileCode = sc.nextLine();
        boolean check = false;
        do {
            System.out.println("Nhập Họ Và Tên :");
            String regexName = "^?$";
            String line = sc.nextLine();
            Pattern patternName = Pattern.compile(regexName);
            Matcher matcherName = patternName.matcher(line);
            if (matcherName.find()) {
                check = true;
                fullName = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        } while (!check);
        boolean check1 = false;
        do {
            System.out.println("Nhập Ngày Tháng Năm Sinh : " + "\n" + " dd/mm/yyyy");
            String regexDateOfBirth = "^[0-9][0-9]+[/]+[0-9][0-9]+[/]+[0-9][0-9][0-9][0-9]$";
            String line = sc.nextLine();
            Pattern patternBirth = Pattern.compile(regexDateOfBirth);
            Matcher matcherBirth = patternBirth.matcher(line);
            if (matcherBirth.find()) {
                check1 = true;
                dateOfBirth = line;
            } else {
                System.out.println("Vui Lòng NHập Đúng Định Dạng");
            }
        } while (!check1);

        System.out.println("Chuẩn Đoán Bệnh : ");
        diagnosis = sc.nextLine();
    }
}
