package places;

import java.util.ArrayList;
import java.util.List;

import schedule.Attack;
import schedule.Blackmail;
import schedule.Corrupt;
import schedule.Dig;
import schedule.Evasion;
import schedule.PrisonAction;

public abstract class Place
{
	public String name;
	public List<PrisonAction> possibleActions;
	//TODO this is not global
	public int guardAwareness;
	public double attackSR, blackmailSR, corruptSR, digSR, evasionSR, resolveLegalSR, stealWeaponToolSR, sellMaterialsSR, stealSR;
	protected int digAdvancement;
	
	protected int posX;
	protected int posY;
	protected int sizeX;
	protected int sizeY;
	
	String information;
	
	public Place()
	{
		guardAwareness = 100;
		digAdvancement = 0;
		possibleActions = new ArrayList<>();
		
		possibleActions.add(new Attack());
		possibleActions.add(new Blackmail());
		possibleActions.add(new Corrupt());
		possibleActions.add(new Dig());
		possibleActions.add(new Evasion());
	}
	

	public int getGuardAwareness() {
		return guardAwareness;
	}

	public void setGuardAwareness(int guardAwareness) {
		this.guardAwareness = guardAwareness;
	}

	public double getAttackSR() {
		return attackSR;
	}

	public void setAttackSR(double attackSR) {
		this.attackSR = attackSR;
	}

	public double getBlackmailSR() {
		return blackmailSR;
	}

	public void setBlackmailSR(double blackmailSR) {
		this.blackmailSR = blackmailSR;
	}

	public double getCorruptSR() {
		return corruptSR;
	}

	public void setCorruptSR(double corruptSR) {
		this.corruptSR = corruptSR;
	}

	public double getDigSR() {
		return digSR;
	}

	public void setDigSR(double digSR) {
		this.digSR = digSR;
	}

	public double getEvasionSR() {
		return evasionSR;
	}

	public void setEvasionSR(double evasionSR) {
		this.evasionSR = evasionSR;
	}

	public double getResolveLegalSR() {
		return resolveLegalSR;
	}

	public void setResolveLegalSR(double resolveLegalSR) {
		this.resolveLegalSR = resolveLegalSR;
	}

	public double getStealWeaponToolSR() {
		return stealWeaponToolSR;
	}

	public void setStealWeaponToolSR(double stealWeaponToolSR) {
		this.stealWeaponToolSR = stealWeaponToolSR;
	}

	public double getSellMaterialsSR() {
		return sellMaterialsSR;
	}

	public void setSellMaterialsSR(double sellMaterialsSR) {
		this.sellMaterialsSR = sellMaterialsSR;
	}

	public double getStealSR() {
		return stealSR;
	}

	public void setStealSR(double stealSR) {
		this.stealSR = stealSR;
	}

	public int getDigAdvancement() {
		return digAdvancement;
	}

	public void setDigAdvancement(int digAdvancement) {
		this.digAdvancement = digAdvancement;
	}
	
	public List<PrisonAction> getPossibleActions()
	{
		return possibleActions;
	}


	public int getPosX() {
		return posX;
	}


	public int getPosY() {
		return posY;
	}


	public int getSizeX() {
		return sizeX;
	}


	public int getSizeY() {
		return sizeY;
	}


	public String getInformation()
	{
		return information;
	}
	
}
