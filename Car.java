package m2_activity6;


public class Car extends Vehicle implements Refuelable {

    public Car(String brand) {
        super(4, brand); 
    }

    @Override
    public void startEngine() {
        System.out.println("Car " + brand + " engine started...");
    }

    @Override
    public void refuel() {
        System.out.println("Car " + brand + " is refueling with gasoline...");
    }

}

