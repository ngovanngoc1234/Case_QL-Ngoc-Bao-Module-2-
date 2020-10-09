package module.Model;

import module.Model.Patient;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransferPatient extends Patient {
    private String deliveryDate;
    private String placeOfTransfer;

    public TransferPatient() {
    }

    public TransferPatient(String profileCode, String fullName, String dateOfBirth, String diagnosis) {
        super(profileCode, fullName, dateOfBirth, diagnosis);
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getPlaceOfTransfer() {
        return placeOfTransfer;
    }

    public void setPlaceOfTransfer(String placeOfTransfer) {
        this.placeOfTransfer = placeOfTransfer;
    }

    @Override
    public String toString() {
        return "Thông Tin Bệnh Nhân Chuyển Viện : " + "\n" +
                " Mã hồ sơ : " + super.getProfileCode() + '\'' +
                ", Họ Tên : " + super.getFullName() + '\'' +
                ", Ngày Tháng Năm Sinh : " + super.getDateOfBirth() + '\'' +
                ", Chuẩn Đoán : " + super.getDiagnosis() + '\'' +
                ", Ngày chuyển viện : '" + deliveryDate + '\'' +
                ", Nơi Chuyển Đến : '" + placeOfTransfer + '\'';
    }

    @Override
    public void addInfo() {
        super.addInfo();
        Scanner sc = new Scanner(System.in);
        boolean check4 = false;
        do {
            System.out.println("Ngày chuyển viện : ");
            System.out.println("dd/mm/yyyy");
            String regexDateOfBirth = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\1|(?:(?:29|30)(\\/|-|\\.)" +
                    "(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)" +
                    "(?:0?2|(?:Feb))\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)" +
                    "(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
            String inputDeliveryDate = sc.nextLine();
            Pattern patternDateOfBirth = Pattern.compile(regexDateOfBirth);
            Matcher matcherDateOfBirth = patternDateOfBirth.matcher(inputDeliveryDate);
            if (matcherDateOfBirth.find()) {
                check4 = true;
                setDeliveryDate(inputDeliveryDate);
            } else {
                System.out.println("Vui Lòng NHập Đúng Định Dạng");
            }
        } while (!check4);

        boolean check5 = false;
        do {
            System.out.println("Nơi Chuyển Đến : ");
            String regexPlaceOfTransfer = "^[a-zA-Z]";
            String inputDeliveryDate = sc.nextLine();
            Pattern patternPlaceOfTransfer = Pattern.compile(regexPlaceOfTransfer);
            Matcher matcherPlaceOfTransfer = patternPlaceOfTransfer.matcher(inputDeliveryDate);
            if (matcherPlaceOfTransfer.find()) {
                check5 = true;
                setPlaceOfTransfer(sc.nextLine());
            } else {
                System.out.println("Vui Lòng NHập vào");
            }
        } while (!check5);
    }
}
