package schedule;


import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.Library;
import places.Place;
import places.Showers;
import places.Workshop;

public class Schedule
{
	Place[] timeTable;
	
	public Schedule()
	{
		timeTable = new Place[9];
		timeTable[0] = new Cell();
		timeTable[1] = new Showers();
		timeTable[2] = new Cafeteria();
		timeTable[3] = new Cell();
		timeTable[4] = new Cafeteria();
		timeTable[5] = new Cell();
		timeTable[6] = new Workshop();
		timeTable[7] = new Showers();
		timeTable[8] = new Cell();
		
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
