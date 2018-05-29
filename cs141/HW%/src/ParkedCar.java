/**
 * Created by Ben on 5/21/2018.
 */
public class ParkedCar extends ParkingTicket{
    private String carMake, carModel, carColor, licenseNumber;
    private double minsParked;
    public ParkedCar(String carMake, String carModel, String carColor, String licenseNumber, double minsParked)
    {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carColor = carColor;
        this.licenseNumber = licenseNumber;
        this.minsParked = minsParked;
    }

    public ParkedCar(ParkedCar copyCar)
    {
        this.carMake = copyCar.getCarMake();
        this.carModel = copyCar.getCarModel();
        this.carColor = copyCar.getCarColor();
        this.licenseNumber = copyCar.getLicenseNumber();
        this.minsParked = copyCar.getMinsParked();
    }
    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getMinsParked() {
        return minsParked;
    }
    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setMinsParked(double minsParked) {
        this.minsParked = minsParked;
    }
    public String toString()
    {
        return "Car Make: " + this.getCarMake() + " Car Model: " + this.getCarModel() + " Car Color: " + this.getCarColor() + " LicenseNumber: " + this.getLicenseNumber() + " Minutes  Parked: " + this.getMinsParked();
    }
}
