package module.Module;

import java.util.Scanner;

public class Outpatients extends Patient {
    private String insuranceBook;
    private String prescriptionCode;


    public String getInsuranceBook() {
        return insuranceBook;
    }

    public void setInsuranceBook(String insuranceBook) {
        this.insuranceBook = insuranceBook;
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode;
    }

    public Outpatients(String profileCode, String fullName, String dateOfBirth, String diagnosis) {
        super(profileCode, fullName, dateOfBirth, diagnosis);
    }

    public Outpatients() {
    }

    @Override
    public String toString() {
        return "Thông Tinh Bệnh Nhân Ngoại Trú : " + '\'' +"\n"+
                " Mã hồ sơ : " + super.getProfileCode() + '\'' +
                ", Họ Tên : " + super.getFullName() + '\'' +
                ", Ngày Tháng Năm Sinh : " + super.getDateOfBirth() + '\'' +
                ", Chuẩn Đoán : " + super.getDiagnosis() + '\'' +
                ", Nhập Số Thẻ Bảo Hiểm :'" + insuranceBook + '\'' +
                ", Mã Đơn Thuốc :'" + prescriptionCode + '\'';
    }

    @Override
    public void addInfo() {
        super.addInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập Số Thẻ Bảo Hiểm : ");
        setInsuranceBook(sc.nextLine()) ;
        System.out.println("Mã Đơn Thuốc : ");
        setPrescriptionCode(sc.nextLine());
    }
}
