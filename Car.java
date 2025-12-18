package main;

// Car.java
public class Car {
    //Attributes
    private String make;
    private String model;
    private int year;


    //No-Args
    public Car() {
        this.make = "Unknown";
        this.model = "Unknown";
        this.year = 0;
    }

    //Parameterized Constructor
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;

    }

    //Method: display info
    public void displayInfo() {
        System.out.println("Car Info:");
        System.out.println("  Make: " + make);
        System.out.println("  Model: " + model);
        System.out.println("  Year: " + year);
        System.out.println(); 
    }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

}
