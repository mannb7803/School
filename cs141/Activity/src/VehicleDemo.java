/**
 * Created by Ben on 4/4/2018.
 */
public class VehicleDemo {
    public static void main(String args[])
    {
        Vehicle v1 = new Vehicle(4, 500, "Charger", "Dodge");
        v1.setName("Hellcat");
        Vehicle v2 = new Vehicle();
        v2.setName("civic");
        v2.setBrand("honda");
        v2.setTires(4);
        v2.setEngineSize(320);
        System.out.println("Car Two Brand: " + v2.getName());
        System.out.println(v1.getName() + " is a powerful car with " + v1.getEngineSize() + " hp");
        System.out.println("The second car has " + v2.getTires() + " tires");
            double mpg = 385.25;
        System.out.println(mpg + " MPG converted to KPL is: " + Vehicle.calculateMpgToKPL(mpg));
    }
}
