 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Driver {
	private static final int CURRENTYEAR = 2018;
	// Add method to read the temps file
	public static ArrayList<Record> readTemperatureFile() throws IOException
	{
		//temp file
		File f1 = new File("project -skeleton2/files/temps-2000s.dat");
		ArrayList<Record> returnArray= new ArrayList<Record>();
		Scanner fInput = new Scanner(f1);

		while(fInput.hasNext())
		{
			int location = fInput.nextInt();
			int year = fInput.nextInt();
			int months = fInput.nextInt();
			double t = fInput.nextDouble();
			if((t >= -50.0 && t <= 50.0) || t == -99.99)
			{
				if(year > 1800 && year < CURRENTYEAR)
				{
					Record input = new Record(location, year, months, t);
					returnArray.add(input);
				}
				else
				{
					System.out.println("invalid year");
				}
			}
			else
			{
				System.out.println("invalid temp");
			}
		}
		return returnArray;
	}
	// Add method to read the queries file
	public static void readQuerieFile(ArrayList<Record> recordArray) throws IOException
	{
		//querie file
		File q = new File("project -skeleton2/files/queries-2000s.dat");
		Scanner queriesInput = new Scanner(q);
		while(queriesInput.hasNext())
		{
			int tempStationId = queriesInput.nextInt();
			String querieType = queriesInput.next();
			int dateLowerbound = queriesInput.nextInt();
			int dateUperbbound = queriesInput.nextInt();
			ArrayList<Record> tempArray = new ArrayList<Record>();
			//makes tempArray only contain Record objects within the given bounds of years
			//this for loop was initially supposed to just take out incorrecy stationIDs than the intended one.
			//i forgot to .clone the passed through array causing a very annoying problem that took me an hour to realize, i should have used .clone but this works so im keeping it
			for(int i =0; i < recordArray.size(); i++)
			{
				if (recordArray.get(i).getStationID() != tempStationId) {
				}
				else
				{
					tempArray.add(recordArray.get(i));
				}
			}
			if(querieType.equalsIgnoreCase("AVG"))
			{
				double tempCurrentTotalTemperature = 0.0;
				for(Record x : tempArray)
				{
					if(x.getYear() >= dateLowerbound && x.getYear() <= dateUperbbound && x.getTemperature() != -99.99)
					{
						tempCurrentTotalTemperature += x.getTemperature();
					}
				}
				System.out.println(tempArray.size()-1);
				tempCurrentTotalTemperature /= tempArray.size()-1;
				writeResults(tempStationId, dateLowerbound, dateUperbbound, querieType, tempCurrentTotalTemperature);
			}
			else if(querieType.equalsIgnoreCase("MODE"))
			{
				double tempCurrentMode = 0;
				int currentModeCounter = 0;
				int counter = 0;
				for(Record a : tempArray)
				{
					counter = 0;
					for(Record test : tempArray)
					{
						if(Math.round(a.getTemperature()) == Math.round(test.getTemperature()))
						{
							counter++;
						}
					}
					//System.out.println(counter + "   " + a.getTemperature());
					if(counter > currentModeCounter)
					{
						currentModeCounter = counter;
						tempCurrentMode = a.getTemperature();
					}
				}
				//System.out.println(tempCurrentMode);
				writeResults(tempStationId, dateLowerbound, dateUperbbound, querieType, tempCurrentMode);
			}
		}
	}
	public static void writeResults(int sID, int lowerYear, int upperYear, String s, double answer) throws IOException
	{

		File print = new File("project -skeleton2/files/results.dat");
		if(!print.exists())
		{
			print.createNewFile();
		}
		FileWriter fr = new FileWriter(print, true);
		PrintWriter pr = new PrintWriter(fr);
		if(answer == 0.0)
		{
			pr.println(sID + "   " + lowerYear + "   " + upperYear + "   " + s + "   unknown");
		}
		else
		{
			if(s.equalsIgnoreCase("mode"))
			{
				answer = Math.round(answer);
				pr.println(sID + "   " + lowerYear + "   " + upperYear + "   " + s + "   " + (int)answer);
			}
			else
			{
				pr.println(sID + "   " + lowerYear + "   " + upperYear + "   " + s + "   " + (answer));
			}
		}
		pr.close();
	}
	// Add method to write to a results.dat file 
	
	public static void sortRecordsList(ArrayList<Record> recordArray){
		Collections.sort(recordArray,new Comparator<Record>() {
				public int compare(Record one, Record other){
					return new Integer(one.getStationID()).compareTo(other.getStationID());
				}
		});
		
		Collections.sort(recordArray,new Comparator<Record>() {
				public int compare(Record one, Record other){
					return new Integer(one.getYear()).compareTo(other.getYear());
				}
		});	
			
	}
	
	public static void main(String[] args) throws IOException{
		 ArrayList<Record> recordList = readTemperatureFile();
		 sortRecordsList(recordList);
//		 for(int i  = 0; i < recordList.size(); i++)
//		 {
//		 	System.out.print("   " + recordList.get(i).getStationID());
//			 System.out.print("   " + recordList.get(i).getYear());
//			 System.out.print("   " +recordList.get(i).getMonth());
//			 System.out.println("   " + recordList.get(i).getTemperature());
//		 }
		 readQuerieFile(recordList);
	}
}
