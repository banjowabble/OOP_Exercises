public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    public MotorBike(String brand, String model, String registrationNumber,
                     Person owner, boolean hasSidecar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSidecar;
    }

    /**
     * get info regarding this motorbike.
     * @return this bike's info
     */
    String getInfo() {
        return "Motor Bike:"
                + "\n\tBrand: " + brand
                + "\n\tModel: " + model
                + "\n\tRegistration Number: " + registrationNumber
                + "\n\tHas Side Car: " + hasSidecar
                + "\n\tBelongs to " + owner.getName()
                + " - " + owner.getAddress();
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
