/**
 * Created by Ben on 5/21/2018.
 */
public class PoliceOfficer extends  ParkingTicket{
    private String officerName, badgeNumber;
    public PoliceOfficer(String officerName, String badgeNumber)
    {
        this.officerName = officerName;
        this.badgeNumber = badgeNumber;
    }
    public PoliceOfficer(PoliceOfficer copyOfficer)
    {
        this.officerName =  copyOfficer.getOfficerName();
        this.badgeNumber = copyOfficer.getBadgeNumber();
    }
    public ParkingTicket patrol(ParkedCar car, ParkingMeter meter)
    {
        if(car.getMinsParked() > meter.getTimeLeftOnMeter())
        {
            return new ParkingTicket(car, this, (int)(car.getMinsParked()-meter.getTimeLeftOnMeter()));
        }
        return null;
    }

    public String getOfficerName() {
        return officerName;
    }

    public String getBadgeNumber() {
        return badgeNumber;
    }

    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    public void setBadgeNumber(String badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    @Override
    public String toString() {
        return "OfficerName: " + officerName + " BadgeNumber: " + badgeNumber;
    }
}
