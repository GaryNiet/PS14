package places;


import schedule.ResolveLegal;
import schedule.WellBeing;

public class PhoneBooth extends Place
{
	public PhoneBooth()
	{
		
		resolveLegalSR = 1;
		
		attackSR = 1;
		blackmailSR = 1;
		corruptSR = 1;
		digSR = 1;
		
		digAdvancement = 0;
		
		
		name = "phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
	
	public PhoneBooth(PhoneBooth _phoneBooth)
	{
		
		resolveLegalSR = _phoneBooth.resolveLegalSR;
		
		attackSR = _phoneBooth.attackSR;
		blackmailSR = _phoneBooth.blackmailSR;
		corruptSR = _phoneBooth.corruptSR;
		digSR = _phoneBooth.digSR;
		
		digAdvancement = _phoneBooth.digAdvancement;
		guardAwareness = _phoneBooth.guardAwareness;
		
		name = "phone booth";
		possibleActions.add(new WellBeing());
		possibleActions.add(new ResolveLegal());
	}
}
