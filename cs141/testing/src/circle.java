
public class circle extends shape
{
    public static void main(String args[])
    {
        Sphere s1 = new Sphere(10);
        s1.calculateVolume(s1.getRadius());
        System.out.println(s1.getVolume());

        s1.calculateCircumference(s1.getRadius());
        System.out.println(s1.getCircumference());

        s1.calculateSurfaceArea(s1.getRadius());
        System.out.println(s1.getSurfaceArea());
    }

    private final static double PICONSTANT =  3.14;
    double radius, volume, surfaceArea, circumference;
    public circle(int radius)
    {
        this.radius =  radius;
    }
    @Override
    public void addToRadius(int radius) {
        this.radius += radius;
    }
    public double getRadius()
    {
        return this.radius;
    }
    public void setRadius(int radius)
    {
        this.radius = radius;
    }
    public static double getPI()
    {
        return PICONSTANT;
    }
    public double getVolume()
    {
        return this.volume;
    }
    public double getSurfaceArea()
    {
        return this.surfaceArea;
    }
    public double getCircumference()
    {
        return this.circumference;
    }

}

/**
 * Created by Ben on 5/14/2018.
 */
interface Formula {
    public void calculateVolume(double radius);
    public void calculateSurfaceArea(double radius);
    public void calculateCircumference(double radius);
}

class Sphere extends circle implements Formula {
    public Sphere(int radius)
    {
        super(radius);
    }
    public void calculateCircumference(double radius) {
        this.circumference =  2 * getPI() * radius;
    }
    public void calculateSurfaceArea(double radius)
    {
        this.surfaceArea = (4 * getPI() * radius * radius);
    }
    public void calculateVolume(double radius)
    {
        this.volume = (radius * radius * radius * 4 / 3 * getPI());
    }
}
