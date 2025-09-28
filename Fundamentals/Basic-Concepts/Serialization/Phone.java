package BasicJava.Serialization;

import java.io.Serializable;

public class Phone implements Serializable {
    private String make;
    private String model;
    private int memory;
    private double camera;
    private double screenSize;
    private String smart;
    private int price;

    @Override
    public String toString() {
        return "make: '" + make + '\'' +
                ", model: '" + model + '\'' +
                ", memory: " + memory +
                ", camera: " + camera +
                ", screenSize: " + screenSize +
                ", smart: '" + smart + '\'' +
                ", price: " + price +
                "\n";
    }

    public Phone(String make, String model, int memory, double camera, double screenSize, String smart, int price) {
        this.make = make;
        this.model = model;
        this.memory = memory;
        this.camera = camera;
        this.screenSize = screenSize;
        this.smart = smart;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMemory() {
        return memory;
    }

    public double getCamera() {
        return camera;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public String getSmart() {
        return smart;
    }

    public int getPrice() {
        return price;
    }
}
