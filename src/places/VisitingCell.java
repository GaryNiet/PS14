package places;


import schedule.ResolveLegal;
import schedule.WellBeing;

public class VisitingCell extends Place
{
	public VisitingCell()
	{
		name = "visiting cell";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
