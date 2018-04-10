/**
 * Created by Ben on 4/2/2018.
 */
public class Vehicle {
    private int tires, engineSize;
    private String name, brand;

    public Vehicle() {
        tires = 0;
        engineSize = 0;
        name = "";
        brand = "";
    }

    public Vehicle(int t, int eSize, String n, String b) {
        tires = t;
        engineSize = eSize;
        name = n;
        brand = b;
    }

    public void setTires(int t) {
        tires = t;
    }

    public void setEngineSize(int eSize) {
        engineSize = eSize;
    }

    public void setName(String n) {
        name = n;
    }

    public void setBrand(String b) {
        brand = b;
    }

    public int getTires() {
        return this.tires;
    }

    public int getEngineSize() {
        return this.engineSize;
    }

    public String getName() {
        return this.name;
    }

    public String brand() {
        return this.brand;
    }

    public static double calculateMpgToKPL(double mpg) {
        double returnValue = 0;
        returnValue = mpg * 0.4251;
        return returnValue;
    }
}

