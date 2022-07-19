package views.tm;

import javafx.scene.control.Button;

public class VehicleTM {
      private String No;
      private String Type;
      private int weight;
      private int noOfPassengers;
      private Button btn;

    public VehicleTM() {
    }

    public VehicleTM(String no, String type, int weight, int noOfPassengers, Button btn) {
        No = no;
        Type = type;
        this.weight = weight;
        this.noOfPassengers = noOfPassengers;
        this.btn = btn;
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "VehicleTM{" +
                "No='" + No + '\'' +
                ", Type='" + Type + '\'' +
                ", weight=" + weight +
                ", noOfPassengers=" + noOfPassengers +
                ", btn=" + btn +
                '}';
    }
}
