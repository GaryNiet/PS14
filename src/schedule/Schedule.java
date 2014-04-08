package schedule;


import places.Cafeteria;
import places.Courtyard;
import places.Library;
import places.Place;

public class Schedule
{
	Place[] timeTable;
	
	public Schedule()
	{
		timeTable = new Place[3];
		timeTable[0] = new Cafeteria();
		timeTable[1] = new Library();
		timeTable[2] = new Courtyard();
	}
	
	public Schedule(Schedule _schedule)
	{
		//TODO
	}
	
	public Place getPlace(int i)
	{
		return timeTable[i];
	}

}
