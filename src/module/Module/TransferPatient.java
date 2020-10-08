package module.Module;

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
            String regexDateOfBirth = "^[0-9][0-9]+[/]+[0-9][0-9]+[/]+[0-9][0-9][0-9][0-9]$";
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
