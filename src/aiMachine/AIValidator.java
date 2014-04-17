package aiMachine;

import java.util.ArrayList;
import java.util.List;

import places.Place;
import schedule.PrisonAction;

public class AIValidator
{
	List<ActionTester> actionTesterList;
	ActionTester attack;
	ActionTester blackmail;
	ActionTester corrupt;
	ActionTester dig;
	ActionTester evasion;
	ActionTester resolveLegal;
	ActionTester stealWT;
	ActionTester sell;
	ActionTester steal;
	ActionTester learn;
	ActionTester wellbeing;
	ActionTester train;
	
	
	public AIValidator()
	{
		attack = new ActionTester("attack");
		blackmail = new ActionTester("blackmail");
		corrupt = new ActionTester("corrupt");
		dig = new ActionTester("dig");
		evasion = new ActionTester("evasion");
		resolveLegal = new ActionTester("resolveLegal");
		stealWT = new ActionTester("stealWT");
		sell = new ActionTester("sell");
		steal = new ActionTester("steal");
		learn = new ActionTester("learn");
		wellbeing = new ActionTester("wellbeing");
		train = new ActionTester("train");
		
		
		
		actionTesterList = new ArrayList<>();
		actionTesterList.add(attack);
		actionTesterList.add(blackmail);
		actionTesterList.add(corrupt);
		actionTesterList.add(dig);
		actionTesterList.add(evasion);
		actionTesterList.add(resolveLegal);
		actionTesterList.add(stealWT);
		actionTesterList.add(sell);
		actionTesterList.add(steal);
		actionTesterList.add(learn);
		actionTesterList.add(wellbeing);
		actionTesterList.add(train);
	}
	
	public void showUsage()
	{
		String leftAlignFormat = "| %-12s | %-9d | %-9d | %-9d | %-9d | %-9d | %-9d | %-9d | %-9d | %-9d |%n";
		
		System.out.format("+--------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.printf("|     name     |   Cell    | Courtyard | cafeteria |  Showers  |  Workshop |Phone Booth| Vstng Cell|  Kitchen  |  Library  |%n");
		System.out.format("+--------------------------------------------------------------------------------------------------------------------------+%n");
		for(ActionTester action: actionTesterList)
		{
			System.out.format(	leftAlignFormat, action.name,  action.getCell(), action.getCourtyard(), action.getCafeteria(),
								action.getShowers(), action.getWorkshop(), action.getPhoneBooth(), action.getVisitingCell(),
								action.getKitchen(), action.getLibrary());
			
		}
		System.out.format("+--------------------------------------------------------------------------------------------------------------------------+%n");
	}
	
	public void update(Place place, PrisonAction action)
	{
		for(ActionTester actionTester: actionTesterList)
		{
			if(action.name.equals(actionTester.name))
			{
				if(place.name.equals("cell"))
				{
					actionTester.setCell(actionTester.getCell() + 1);
				}
				else if(place.name.equals("courtyard"))
				{
					actionTester.setCourtyard(actionTester.getCourtyard() + 1);
				}
				else if(place.name.equals("cafeteria"))
				{
					actionTester.setCafeteria(actionTester.getCafeteria() + 1);
				}
				else if(place.name.equals("showers"))
				{
					actionTester.setShowers(actionTester.getShowers() + 1);
				}
				else if(place.name.equals("workshop"))
				{
					actionTester.setWorkshop(actionTester.getWorkshop() + 1);
				}
				else if(place.name.equals("phone booth"))
				{
					actionTester.setPhoneBooth(actionTester.getPhoneBooth() + 1);
				}
				else if(place.name.equals("visiting cell"))
				{
					actionTester.setVisitingCell(actionTester.getVisitingCell() + 1);
				}
				else if(place.name.equals("kitchen"))
				{
					actionTester.setKitchen(actionTester.getKitchen() + 1);
				}
				else if(place.name.equals("library"))
				{
					actionTester.setLibrary(actionTester.getLibrary() + 1);
				}
			}
		}
	}
}
