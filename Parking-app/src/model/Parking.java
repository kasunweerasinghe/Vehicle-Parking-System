package model;

public class Parking {
    private String No;
    private String type;
    private String slotNo;
    private String dateTime;

    public Parking() {
    }

    public Parking(String no, String type, String slotNo, String dateTime) {
        No = no;
        this.type = type;
        this.slotNo = slotNo;
        this.dateTime = dateTime;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "No='" + No + '\'' +
                ", type='" + type + '\'' +
                ", slotNo='" + slotNo + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
