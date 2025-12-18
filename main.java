package main;


// Main.java
public class main {
    public static void main(String[] args) {
     
        Car car1 = new Car();
        
        car1.setMake("Toyota");
        car1.setModel("Vios");
        car1.setYear(2018);


        // Call method
        car1.displayInfo();
        

  
        Car car2 = new Car("Honda", "Civic", 2022);


        car2.displayInfo();

    }
}
