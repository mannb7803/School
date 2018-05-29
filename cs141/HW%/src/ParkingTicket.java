/**
 * Created by Ben on 5/21/2018.
 */
public class ParkingTicket {
    private ParkedCar car;
    private PoliceOfficer officer;
    private int minutes;
    private double fine;
    private final double BASE_FINE = 35.0, HOURLY_FINE = 10.0;
    public  ParkingTicket() {
    }
    public ParkingTicket(ParkedCar aCar, PoliceOfficer anOfficer, int  min)
    {
        this.car =  aCar;
        this.officer = anOfficer;
        this.minutes = min;
    }
    public ParkingTicket(ParkingTicket copyTicket)
    {
        this.car = copyTicket.getCar();
        this.officer = copyTicket.getOfficer();
        this.minutes = copyTicket.getMinutes();
    }
    public void setCar(ParkedCar car) {
        this.car = car;
    }

    public void setOfficer(PoliceOfficer officer) {
        this.officer = officer;
    }
    public void calculateFine()
    {
        this.fine = 0;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public ParkedCar getCar() {
        return car;
    }

    public PoliceOfficer getOfficer() {
        return officer;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getFine() {

        double returnFine  = BASE_FINE;
        while(minutes > 60)
        {
          minutes-=60;
          returnFine+=HOURLY_FINE;
        }    return getFine();
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "car=" + car +
                ", officer=" + officer +
                ", minutes=" + minutes +
                ", fine=" + fine +
                ", BASE_FINE=" + BASE_FINE +
                ", HOURLY_FINE=" + HOURLY_FINE +
                '}';
    }
}
