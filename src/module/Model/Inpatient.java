package module.Model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inpatient extends Patient {

    private String hospitalizedDay;
    private String dayOfDischarge;
    private String facultyName;
    private int numberOfBeds;

    public Inpatient(String profileCode, String fullName, String dateOfBirth, String diagnosis) {
        super(profileCode, fullName, dateOfBirth, diagnosis);
    }

    public Inpatient() {
    }

    public String getHospitalizedDay() {
        return hospitalizedDay;
    }

    public void setHospitalizedDay(String hospitalizedDay) {
        this.hospitalizedDay = hospitalizedDay;
    }

    public String getDayOfDischarge() {
        return dayOfDischarge;
    }

    public void setDayOfDischarge(String dayOfDischarge) {
        this.dayOfDischarge = dayOfDischarge;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public String toString() {
        return "Thông Tin Bệnh Nhân Nội Trú : " +"\n"+
                ", Mã hồ sơ : " + super.getProfileCode() + '\'' +
                ", Họ Tên : " + super.getFullName() + '\'' +
                ", Ngày Tháng Năm Sinh : " + super.getDateOfBirth() + '\'' +
                ", Chuẩn Đoán : " + super.getDiagnosis() + '\'' +
                ", Ngày Nhập Viện :'" + hospitalizedDay + '\'' +
                ", Ngày Xuất Viện :'" + dayOfDischarge + '\'' +
                ", Tên KHoa :'" + facultyName + '\'' +
                ", Số Gường Bệnh :" + numberOfBeds + '\'';
    }

    @Override
    public void addInfo() {
        super.addInfo();
        Scanner sc = new Scanner(System.in);
        boolean check3 = false;
        do {
            System.out.println("Ngày Nhập Viện :" + "\n" + " dd/mm/yyyy");
            String regexHospitalizedDay = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            String nextLine = sc.nextLine();
            Pattern patternHospitalizedDay = Pattern.compile(regexHospitalizedDay);
            Matcher matcherHospitalizedDay = patternHospitalizedDay.matcher(nextLine);
            if (matcherHospitalizedDay.find()) {
                check3 = true;
                setHospitalizedDay(nextLine);
            } else {
                System.out.println("Vui Lòng NHập Đúng Định Dạng");
            }
        } while (!check3);
        boolean check2 = false;
        do {
            System.out.println("Ngày Xuất Viện : " + "\n" + " dd/mm/yyyy");
            String regexOfDischarge ="^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            String inputsOfDischarge = sc.nextLine();
            Pattern patternOfDischarge = Pattern.compile(regexOfDischarge);
            Matcher matcherOfDischarge = patternOfDischarge.matcher(inputsOfDischarge);
            if (matcherOfDischarge.find()) {
                check2 = true;
                setDayOfDischarge(inputsOfDischarge) ;
            } else {
                System.out.println("Vui Lòng NHập Đúng Định Dạng");
            }
        } while (!check2);

        boolean check4 = false;
        do {
            System.out.println("Tên Khoa : ");
            String regexHospitalizedDay = "^[a-zA-Z]$";
            String nextLine = sc.nextLine();
            Pattern patternFacultyName = Pattern.compile(regexHospitalizedDay);
            Matcher matcherFacultyName = patternFacultyName.matcher(nextLine);
            if (matcherFacultyName.find()) {
                check4 = true;
                setFacultyName(sc.nextLine());
            } else {
                System.out.println("Vui Lòng Nhập vào");
            }
        } while (!check4);

        boolean check5 = false;
        do {
            System.out.println("Số Gường Nằm : ");
            System.out.println("  star 00 =>");
            String regexHospitalizedDay = "^\\d{2}$";
            String nextLine = sc.nextLine();
            Pattern patternNumberOfBeds = Pattern.compile(regexHospitalizedDay);
            Matcher matcherNumberOfBeds = patternNumberOfBeds.matcher(nextLine);
            if (matcherNumberOfBeds.find()) {
                check5 = true;
                setNumberOfBeds(sc.nextInt());
            } else {
                System.out.println("Vui Lòng Nhập vào");
            }
        } while (!check5);
    }
}
