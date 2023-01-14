package homework.transport;

import homework.Validation;

import java.util.Objects;

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
    private Boolean isSummerTyre;
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
               Boolean isSummerTyre,
               Key key) {
        this.brand = Validation.validateString(brand, "default");
        this.model = Validation.validateString(model, "default");
        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = Validation.validateString(color, "белый");
        this.year = validateYear(year);
        this.country = Validation.validateString(country, "default");
        this.gearBox = Validation.validateString(gearBox, "default");
        this.bodyType = Validation.validateString(bodyType, "default");
        this.registrationNumber = Validation.validateString(registrationNumber, "default");
        this.seatQuantity = validateSeatQuantity(seatQuantity);
        this.isSummerTyre = Validation.validateBoolean(isSummerTyre);
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
        this.color = Validation.validateString(color, "белый");
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
        this.gearBox = Validation.validateString(gearBox, "default");
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = Validation.validateString(registrationNumber, "default");
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
        private final Boolean isRemoteEngineStart;
        private final Boolean isKeylessEntry;

        public Key(Boolean isRemoteEngineStart, Boolean isKeylessEntry) {
            this.isRemoteEngineStart = Validation.validateBoolean(isRemoteEngineStart);
            this.isKeylessEntry = Validation.validateBoolean(isKeylessEntry);
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
//        String remoteStart =
        return brand + " " + model + "\n    год выпуска - " + year + "\n    страна сборки - " + country + "\n    цвет - "
                + color + "\n    объем двигателя - " + engineVolume + " л\n    коробка передач - " + gearBox + "\n    тип кузова - "
                + bodyType + "\n    регистрационный номер - " + registrationNumber + "\n    количество мест - "
                + seatQuantity + "\n    резина - " + summerTyre + "\n    " + key;
    }

    //  Метод для замены шин (летней на зимнюю и наоборот) в зависимости от сезона (летняя - с апреля по октябрь)
    public static boolean changeTyre(int currentMonth) {
        return currentMonth > 3 && currentMonth < 11;
    }

    //  Блок валидации параметров применительно только к данному классу
    public double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }

    public int validateYear(int year) {
        return year <= 0 ? 2000 : year;
    }

    public int validateSeatQuantity(int seatQuantity) {
        return seatQuantity <= 0 ? 4 : seatQuantity;
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
