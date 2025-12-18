package m2_activity6;


public class Truck extends Vehicle implements Refuelable {

    public Truck(String brand, int numberOfWheels) {
        super(numberOfWheels, brand); 
    }

    @Override
    public void startEngine() {
        System.out.println("Truck " + brand + " engine started...");
    }

    @Override
    public void refuel() {
        System.out.println("Truck " + brand + " is refueling with diesel..");
    }

}
