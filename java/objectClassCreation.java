class Car{
    String make;
    String model;
    int year;
    public void displayDetails(){
        System.out.println("Make : "+make);
        System.out.println("model : "+model);
        System.out.println("Year : "+year);
    }
}

public class objectClassCreation {
    
    public static void main(String[] args) {
        Car c=new Car();
        c.make="Toyota";
        c.model="benz";
        c.year=2024;
        Car c1=new Car();
        c1.make="Hyundai";
        c1.model="tata";
        c1.year=2024;
        c.displayDetails();
        c1.displayDetails();
    }
}
