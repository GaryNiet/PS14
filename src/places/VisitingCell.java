package places;

import java.util.ArrayList;

import schedule.WellBeing;

public class VisitingCell extends Place
{
	public VisitingCell()
	{
		name = "visiting cell";
		possibleActions.add(new WellBeing());
	}
}
