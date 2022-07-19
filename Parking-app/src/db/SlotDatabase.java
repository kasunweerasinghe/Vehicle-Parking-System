package db;

import model.Slot;

import java.util.ArrayList;

public class SlotDatabase {
    public static ArrayList<Slot> slotTable = new ArrayList<Slot>();

    static{
       slotTable.add(
               new Slot("Van","1","notUse")
       );
        slotTable.add(
                new Slot("Van","2","notUse")
        );
        slotTable.add(
                new Slot("Van","3","notUse")
        );
        slotTable.add(
                new Slot("Van","4","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","5","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","6","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","7","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","8","notUse")
        );
        slotTable.add(
                new Slot("Cargo Lorry","9","notUse")
        );
    }
}
