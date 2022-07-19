package views.tm;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class DriverTM {
      private String name;
      private String nic;
      private String driverLicenseNo;
      private String address;
      private String contactNo;
      private Button btn;

    public DriverTM() {
    }

    public DriverTM(String name, String nic, String driverLicenseNo, String address, String contactNo, Button btn) {
        this.name = name;
        this.nic = nic;
        this.driverLicenseNo = driverLicenseNo;
        this.address = address;
        this.contactNo = contactNo;
        this.btn = btn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "DriverTM{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", driverLicenseNo='" + driverLicenseNo + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", btn=" + btn +
                '}';
    }
}
