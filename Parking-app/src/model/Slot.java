package model;

public class Slot {
    private String vehicleType;
    private String slotNo;
    private String option;

    public Slot() {
    }

    public Slot(String vehicleType, String slotNo, String option) {
        this.vehicleType = vehicleType;
        this.slotNo = slotNo;
        this.option = option;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public String getOption(String notUse) {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "vehicleType='" + vehicleType + '\'' +
                ", slotNo='" + slotNo + '\'' +
                ", option='" + option + '\'' +
                '}';
    }
}
