package model;

public class Vehicle {
     private String No;
     private String Type;
     private int weight;
     private int noOfPassengers;

    public Vehicle() {
    }

    public Vehicle(String no, String type, int weight, int noOfPassengers) {
        No = no;
        Type = type;
        this.weight = weight;
        this.noOfPassengers = noOfPassengers;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "No='" + No + '\'' +
                ", Type='" + Type + '\'' +
                ", weight=" + weight +
                ", noOfPassengers=" + noOfPassengers +
                '}';
    }
}
