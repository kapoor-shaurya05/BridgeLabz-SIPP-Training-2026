import java.util.ArrayList;

public class SmartParkingManager {

    static ArrayList<String> vehicles = new ArrayList<>();

    public static void addVehicle(String number) {

        vehicles.add(number);
        System.out.println(number + " Entered Parking.");
    }

    public static void removeVehicle(String number) {

        if (vehicles.remove(number)) {
            System.out.println(number + " Exited Parking.");
        }
        else {
            System.out.println("Vehicle Not Found.");
        }
    }

    public static void searchVehicle(String number) {

        if (vehicles.contains(number)) {
            System.out.println(number + " is currently parked.");
        }
        else {
            System.out.println("Vehicle not parked.");
        }
    }

    public static void displayVehicles() {

        System.out.println("\nParked Vehicles:");

        for (String v : vehicles)
            System.out.println(v);

        System.out.println("Occupied Slots : " + vehicles.size());
    }

    public static void main(String[] args) {

        addVehicle("UP15AB1234");
        addVehicle("DL8CAF5678");
        addVehicle("HR26XY1111");

        searchVehicle("DL8CAF5678");
        removeVehicle("HR26XY1111");
        displayVehicles();
    }
}