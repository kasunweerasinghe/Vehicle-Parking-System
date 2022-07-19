package db;

import model.Vehicle;

import java.util.ArrayList;

public class VehicleDatabase {
    public static ArrayList<Vehicle> vehicleTable = new ArrayList<Vehicle>();

    static{
        vehicleTable.add(
                new Vehicle("NA-3434","Bus",3500,60)
        );
        vehicleTable.add(
                new Vehicle("KA-4563","Van",1000,7)
        );
        vehicleTable.add(
                new Vehicle("GF-4358","Van",800,4)
        );
        vehicleTable.add(
                new Vehicle("CCB-3568","Van",1800,8)
        );
        vehicleTable.add(
                new Vehicle("LM-66794","Van",1500,4)
        );
        vehicleTable.add(
                new Vehicle("QA-3369","Van",1800,6)
        );
        vehicleTable.add(
                new Vehicle("KB-36684","Cargo Lorry ",2500,2)
        );
        vehicleTable.add(
                new Vehicle("JJ-9878","Cargo Lorry",3000,2)
        );
        vehicleTable.add(
                new Vehicle("GH-5772","Cargo Lorry",4000,3)
        );
        vehicleTable.add(
                new Vehicle("XY-4456","Cargo Lorry",3500,2)
        );
        vehicleTable.add(
                new Vehicle("YQ-3536","Cargo Lorry",2000,2)
        );
        vehicleTable.add(
                new Vehicle("CBB-3566","Cargo Lorry",2500,2)
        );
        vehicleTable.add(
                new Vehicle("QH-3444","Cargo Lorry",5000,4)
        );
    }
}
