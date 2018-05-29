/**
 * Created by Ben on 5/21/2018.
 */
public class ParkingMeter {
    private double timeLeftOnMeter;
    public ParkingMeter(double timeLeftOnMeter)
    {
        this.timeLeftOnMeter = timeLeftOnMeter;
    }
    public double  getTimeLeftOnMeter()
    {
        return this.timeLeftOnMeter;
    }
    public static void main (String args[])
    {
        System.out.println("\n... set minutes purchased to 60, and");
        System.out.println(" parked for 125 minutes...");
// Create a ParkedCar object.
// The car was parked for 125 minutes.
        ParkedCar car = new ParkedCar("Volkswagen", "2002", "Red", "3RHZ147", 125);
// Create a ParkingMeter object. 60 minutes were purchased.
        ParkingMeter meter = new ParkingMeter(60);
// Create a PoliceOfficer object.
        PoliceOfficer officer = new PoliceOfficer("Joe Friday", "4788");
// Let the officer patrol.
        ParkingTicket ticket = officer.patrol(car, meter);
// Did the officer issue a ticket?
        if (ticket != null)
            System.out.println(ticket);
        else
            System.out.println("No crimes committed!");
    }
}
