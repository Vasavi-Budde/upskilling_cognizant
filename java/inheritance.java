 class Animal{
     public void makeSound(){
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    public void makeSound(){
        System.out.println("Dog barks");
    }
}

public class inheritance {
    public static void main(String[] args) {
        
    Animal a=new Animal();
    Animal d=new Dog();
    d.makeSound();
    a.makeSound();
}
}