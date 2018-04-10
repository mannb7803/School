public class Record implements Comparable<Record>{
	private int  stationID, year, month;
	private double temperature;
	public Record()
	{

	}
	public Record(int sID, int y, int m,  double t)
	{
		stationID =  sID;
		year = y;
		month = m;
		temperature = t;
	}
	public int compareTo(Record other){
		return new Integer(year).compareTo(other.year);
	}
	public void setStationID(int sID)
	{
		stationID = sID;
	}
	public void setYear(int y)
	{
		year = y;
	}
	public void setMonth(int m)
	{
		month = m;
	}
	public void setTemperature(double t)
	{
		temperature = t;
	}
	public int getStationID()
	{
		return this.stationID;
	}
	public int getYear()
	{
		return this.year;
	}
	public int getMonth()
	{
		return this.month;
	}
	public double getTemperature()
	{
		return temperature;
	}
}
