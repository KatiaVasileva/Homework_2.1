package Homework1;

public class Main {
    public static void main(String[] args) {

        insertSeparator();
        System.out.println("Задача 1");

        Car myCar1 = new Car();
        myCar1.setBrand("Lada");
        myCar1.setModel("Granta");
        myCar1.setEngineVolume(1.7);
        myCar1.setColor("желтого");
        myCar1.setYear(2015);
        myCar1.setCountry("Россия");
        System.out.println(myCar1);

        Car myCar2 = new Car();
        myCar2.setBrand("Audi");
        myCar2.setModel("A8 50 L TDI quattro");
        myCar2.setEngineVolume(3.0);
        myCar2.setColor("черного");
        myCar2.setYear(2020);
        myCar2.setCountry("Германия");
        System.out.println(myCar2);

        Car myCar3 = new Car();
        myCar3.setBrand("BMW");
        myCar3.setModel("Z8");
        myCar3.setEngineVolume(3.0);
        myCar3.setColor("черного");
        myCar3.setYear(2021);
        myCar3.setCountry("Германия");
        System.out.println(myCar3);

        Car myCar4 = new Car();
        myCar4.setBrand("Kia");
        myCar4.setModel("Sportage 4-го поколения");
        myCar4.setEngineVolume(2.4);
        myCar4.setColor("красного");
        myCar4.setYear(2018);
        myCar4.setCountry("Южная Корея");
        System.out.println(myCar4);

        Car myCar5 = new Car();
        myCar5.setBrand("Hyundai");
        myCar5.setModel("Avante");
        myCar5.setEngineVolume(1.6);
        myCar5.setColor("оранжевого");
        myCar5.setYear(2016);
        myCar5.setCountry("Южная Корея");
        System.out.println(myCar5);

        insertSeparator();
        System.out.println("Задача 2-3");

        Car car1 = new Car("Lada","Granta", 1.7,  "желтого", 2015, "");
        Car car2 = new Car("Audi", "A8 50 L TDI quattro", 3.0, "", 2020, "Германия");
        Car car3 = new Car("BMW", "", 3.0, "черного", 2021, "Германия");
        Car car4 = new Car("Kia", "Sportage 4-го поколения", 2.4, "красного", 0, "Южная Корея");
        Car car5 = new Car("Hyundai", "Avante", 0, "оранжевого", 2016, "Южная Корея");

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);
        System.out.println(car5);

        insertSeparator();
    }

    public static void insertSeparator() {
        System.out.println("===================================================================================================================");
    }
}
