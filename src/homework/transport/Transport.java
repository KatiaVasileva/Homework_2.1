package homework.transport;

import homework.Validation;

public class Transport {
    private final String brand;
    private final String model;
    private final int year;
    private final String country;
    private String color;
    private int maxSpeed;

    public Transport(String brand,
                     String model,
                     int year,
                     String country,
                     String color,
                     int maxSpeed) {
        this.brand = Validation.validateCarParameter(brand);
        this.model = Validation.validateCarParameter(model);
        this.year = validateYear(year);
        this.country = Validation.validateCarParameter(country);
        this.color = validateColor(color);
        this.maxSpeed = validateMaxSpeed(maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = validateColor(color);
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = validateMaxSpeed(maxSpeed);
    }

    //  Блок валидации параметров
    public int validateYear(int year) {
        return year <= 0 ? 2000 : year;
    }

    public String validateColor(String color) {
        return Validation.validateString(color, "белый");
    }

    public int validateMaxSpeed(int maxSpeed) {
        return maxSpeed <= 0 ? 160 : maxSpeed;
    }

    @Override
    public String toString() {
        return brand + " " + model + "\n    год выпуска - " + year + "\n    страна сборки - " + country +
                "\n    цвет - " + color + "\n    максимальная скорость - " + maxSpeed + " км/ч";
    }
}
