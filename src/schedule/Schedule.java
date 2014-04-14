package schedule;


import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.Kitchen;
import places.Library;
import places.PhoneBooth;
import places.Place;
import places.Showers;
import places.VisitingCell;
import places.Workshop;

public class Schedule
{
	Place[] timeTable;
	List<Place> allPlaces;
	Cell cell;
	Courtyard courtyard;
	Cafeteria cafeteria;
	Showers showers;
	Workshop workshop;
	PhoneBooth phoneBooth;
	VisitingCell visitingCell;
	Kitchen kitchen;
	Library library;
	
	public Schedule()
	{
		allPlaces = new ArrayList<>();
		initPlaces();
		
		timeTable = new Place[9];
		timeTable[0] = cell;
		timeTable[1] = showers;
		timeTable[2] = cafeteria;
		timeTable[3] = courtyard;
		timeTable[4] = cafeteria;
		timeTable[5] = cell;
		timeTable[6] = workshop;
		timeTable[7] = showers;
		timeTable[8] = cell;
		
	}
	
	public Schedule(Schedule _schedule)
	{
		allPlaces = new ArrayList<>();
		
		cell = _schedule.cell;
		courtyard = _schedule.courtyard;
		cafeteria = _schedule.cafeteria;
		showers = _schedule.showers;
		workshop = _schedule.workshop;
		phoneBooth = _schedule.phoneBooth;
		visitingCell = _schedule.visitingCell;
		kitchen = _schedule.kitchen;
		library = _schedule.library;
		
		allPlaces.add(cell);
		allPlaces.add(courtyard);
		allPlaces.add(cafeteria);
		allPlaces.add(showers);
		allPlaces.add(workshop);
		allPlaces.add(phoneBooth);
		allPlaces.add(visitingCell);
		allPlaces.add(kitchen);
		allPlaces.add(cell);
		
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
	
	private void initPlaces()
	{
		cell = new Cell();
		courtyard = new Courtyard();
		cafeteria = new Cafeteria();
		showers = new Showers();
		workshop = new Workshop();
		phoneBooth = new PhoneBooth();
		visitingCell = new VisitingCell();
		kitchen = new Kitchen();
		library = new Library();
		
		allPlaces.add(cell);
		allPlaces.add(courtyard);
		allPlaces.add(cafeteria);
		allPlaces.add(showers);
		allPlaces.add(workshop);
		allPlaces.add(phoneBooth);
		allPlaces.add(visitingCell);
		allPlaces.add(kitchen);
		allPlaces.add(cell);
		
	}
	
	public Place getPlace(int i)
	{
		
		return timeTable[i];
	}
	
	public List<Place> getAllPlaces()
	{
		return allPlaces;
	}

}
