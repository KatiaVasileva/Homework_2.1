package homework.transport;

public class CarTest {
    public static void main(String[] args) {

        Car testCar = new Car(
                "Audi",
                "",
                1.7,
                "зеленый",
                0,
                "",
                "автоматическая",
                null,
                "л45щз",
                0,
                true,
                new Car.Key(true, false));

        System.out.println("Блок проверки");

        System.out.println(testCar);
        testCar.setEngineVolume(0);
        testCar.setColor("");
        testCar.setGearBox(" ");
        testCar.setRegistrationNumber("");
        System.out.println(testCar);
    }
}
