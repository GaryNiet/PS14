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
		timeTable = new Place[9];
		timeTable[0] = _schedule.timeTable[0];
		timeTable[1] = _schedule.timeTable[1];
		timeTable[2] = _schedule.timeTable[2];
		timeTable[3] = _schedule.timeTable[3];
		timeTable[4] = _schedule.timeTable[4];
		timeTable[5] = _schedule.timeTable[5];
		timeTable[6] = _schedule.timeTable[6];
		timeTable[7] = _schedule.timeTable[7];
		timeTable[8] = _schedule.timeTable[8];
	}
	
	public Place getPlace(int i)
	{
		
		return timeTable[i];
	}

}
