package module.Model;

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

    public Patient() {}

    public Patient(String profileCode, String fullName, String dateOfBirth, String diagnosis) {
        this.profileCode = profileCode;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return " Mã hồ sơ : " + profileCode + '\'' +
                ", Họ Tên : " + fullName + '\'' +
                ", Ngày Tháng Năm Sinh : " + dateOfBirth + '\'' +
                ", Chuẩn Đoán : " + diagnosis + '\'';
    }

    
    public void addInfo() {
        Scanner sc = new Scanner(System.in);

        boolean check2 = false;
        do {
            System.out.println("Nhập Mã Hồ Sơ  :");
            String regexName = "^BN+\\$";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(regexName);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check2 = true;
                setProfileCode(sc.nextLine());
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        } while (!check2);

        boolean check = false;
        do {
            System.out.println("Nhập Họ Và Tên :");
            String regexName = "^[a-zA-Z]\\s+?";
            String line = sc.nextLine();
            Pattern patternName = Pattern.compile(regexName);
            Matcher matcherName = patternName.matcher(line);
            if (matcherName.find()) {
                check = true;
                setFullName(line);
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        } while (!check);

        boolean check1 = false;
        do {
            System.out.println("Nhập Ngày Tháng Năm Sinh : " + "\n" + " dd/mm/yyyy");
            String regexDateOfBirth = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            String line = sc.nextLine();
            Pattern patternBirth = Pattern.compile(regexDateOfBirth);
            Matcher matcherBirth = patternBirth.matcher(line);
            if (matcherBirth.find()) {
                check1 = true;
                setDateOfBirth(line);
            } else {
                System.out.println("Vui Lòng NHập Đúng Định Dạng");
            }
        } while (!check1);

        boolean check3 = false;
        do {
            System.out.println("Chuẩn Đoán Bệnh : ");
            String regex = "^[a-zA-Z]+?$";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check3 = true;
                setDiagnosis(sc.nextLine());
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        } while (!check3);

    }
}
