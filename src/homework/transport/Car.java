package homework.transport;

import homework.Validation;

import java.util.Objects;
import java.util.regex.Pattern;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String gearBox;
    private final String bodyType;
    private String registrationNumber;
    private final int seatQuantity;
    private boolean isSummerTyre;
    private final Key key;

    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               int year,
               String country,
               String gearBox,
               String bodyType,
               String registrationNumber,
               int seatQuantity,
               boolean isSummerTyre,
               Key key) {
        this.brand = validateCarParameter(brand);
        this.model = validateCarParameter(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = validateColor(color);
        this.year = validateYear(year);
        this.country = validateCarParameter(country);
        this.gearBox = validateCarParameter(gearBox);
        this.bodyType = validateCarParameter(bodyType);
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
        this.seatQuantity = validateSeatQuantity(seatQuantity);
        this.isSummerTyre = validateCarParameter(isSummerTyre);
        this.key = key;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = validateEngineVolume(engineVolume);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = validateColor(color);
    }

    public int getYear() {
        return year;
    }


    public String getCountry() {
        return country;
    }

    public String getGearBox() {
        return gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = validateCarParameter(gearBox);
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
    }

    public int getSeatQuantity() {
        return seatQuantity;
    }

    public boolean getSummerTyre() {
        return isSummerTyre;
    }

    public void setSummerTyre(boolean summerTyre) {
        this.isSummerTyre = summerTyre;
    }

    public Key getKey() {
        return key;
    }

    public static class Key {
        private final boolean isRemoteEngineStart;
        private final boolean isKeylessEntry;

        public Key(boolean isRemoteEngineStart, boolean isKeylessEntry) {
            this.isRemoteEngineStart = validateCarParameter(isRemoteEngineStart);
            this.isKeylessEntry = validateCarParameter(isKeylessEntry);
        }

        @Override
        public String toString() {
            String remoteStart = isRemoteEngineStart ? "удаленный запуск двигателя - есть" : "удаленный запуск двигателя - нет";
            String keylessEntry = isKeylessEntry ? "бесключевой доступ - есть" : "бесключевой доступ - нет";
            return remoteStart + "\n    " + keylessEntry + "\n";
        }
    }

    @Override
    public String toString() {
        String summerTyre = isSummerTyre ? "летняя" : "зимняя";
        return brand + " " + model + "\n    объем двигателя - " + engineVolume + " л\n    цвет - " + color +
                "\n    год выпуска - " + year + "\n    страна сборки - " + country + "\n    коробка передач - " + gearBox +
                "\n    тип кузова - " + bodyType + "\n    регистрационный номер - " + registrationNumber +
                "\n    количество мест - " + seatQuantity + "\n    резина - " + summerTyre + "\n    " + key;
    }

    //  Метод для замены шин (летней на зимнюю и наоборот) в зависимости от месяца (летняя - с апреля по октябрь)
    public static boolean changeTyre(int currentMonth) {
        return currentMonth > 3 && currentMonth < 11;
    }

    //  Блок валидации параметров
    public String validateCarParameter(String carParameter) {
        return Validation.validateString(carParameter, "default");
    }

    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }

    public String validateColor(String color) {
        return Validation.validateString(color, "белый");
    }

    public int validateYear(int year) {
        return year <= 0 ? 2000 : year;
    }

    public String validateRegistrationNumber(String registrationNumber) {
        if (Pattern.matches("[авекмнорстух][0-9]{3}[авекмнорстух]{2}[0-9]{2,3}",registrationNumber)) {
            return registrationNumber;
        } else {
            return "ошибка! регистрационный номер указан неверно";
        }
    }
    public int validateSeatQuantity(int seatQuantity) {
        return seatQuantity <= 0 ? 4 : seatQuantity;
    }

    public static boolean validateCarParameter(boolean carParameter) {
        return Validation.validateBoolean(carParameter);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Car car = (Car) other;
        return year == car.year && seatQuantity == car.seatQuantity && Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) && Objects.equals(country, car.country) && Objects.equals(bodyType, car.bodyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, country, bodyType, seatQuantity);
    }
}
