package schedule;


import java.util.ArrayList;
import java.util.List;

import places.Cafeteria;
import places.Cell;
import places.Courtyard;
import places.Free;
import places.Job;
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
	Free free;
	Job job;
	
	public Schedule()
	{
		allPlaces = new ArrayList<>();
		initPlaces();
		
		timeTable = new Place[9];
		timeTable[0] = cell;
		timeTable[1] = showers;
		timeTable[2] = cafeteria;
		timeTable[3] = job;
		timeTable[4] = cafeteria;
		timeTable[5] = job;
		timeTable[6] = free;
		timeTable[7] = showers;
		timeTable[8] = cell;
		
	}
	
	public Schedule(Schedule _schedule)
	{
		allPlaces = new ArrayList<>();
		
		cell = new Cell(_schedule.cell);
		courtyard = new Courtyard(_schedule.courtyard);
		cafeteria = new Cafeteria(_schedule.cafeteria);
		showers = new Showers(_schedule.showers);
		workshop = new Workshop(_schedule.workshop);
		phoneBooth = new PhoneBooth(_schedule.phoneBooth);
		visitingCell = new VisitingCell(_schedule.visitingCell);
		kitchen = new Kitchen(_schedule.kitchen);
		library = new Library(_schedule.library);
		free = new Free(_schedule.free);
		job = new Job(_schedule.job);
		
		allPlaces.add(cell);
		allPlaces.add(courtyard);
		allPlaces.add(cafeteria);
		allPlaces.add(showers);
		allPlaces.add(workshop);
		allPlaces.add(phoneBooth);
		allPlaces.add(visitingCell);
		allPlaces.add(kitchen);
		allPlaces.add(library);
		
		timeTable = new Place[9];
		timeTable[0] = cell;
		timeTable[1] = showers;
		timeTable[2] = cafeteria;
		timeTable[3] = job;
		timeTable[4] = cafeteria;
		timeTable[5] = job;
		timeTable[6] = free;
		timeTable[7] = showers;
		timeTable[8] = cell;
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
		free = new Free();
		job = new Job();
		
		allPlaces.add(cell);
		allPlaces.add(courtyard);
		allPlaces.add(cafeteria);
		allPlaces.add(showers);
		allPlaces.add(workshop);
		allPlaces.add(phoneBooth);
		allPlaces.add(visitingCell);
		allPlaces.add(kitchen);
		allPlaces.add(library);
		
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
