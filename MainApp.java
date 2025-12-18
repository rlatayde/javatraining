package m2_activity6;


public class MainApp {
    public static void main(String[] args) {

        Car car = new Car("Toyota");
        Truck truck = new Truck("Volvo", 10);


        car.startEngine();          
        car.refuel();               
        System.out.println("Car brand: " + car.getBrand());
        System.out.println("Car wheels: " + car.getNumberOfWheels());
         
        System.out.println();

        truck.startEngine();        
        truck.refuel();             
        System.out.println("Truck brand: " + truck.getBrand());
        System.out.println("Truck wheels: " + truck.getNumberOfWheels());


        System.out.println();
        
        destroyVehicle(car);
        destroyVehicle(truck);
    }


    public static void destroyVehicle(Vehicle vehicle) {
        vehicle.destroy();
    }
}
