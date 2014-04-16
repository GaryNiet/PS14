package aiMachine;

public class ActionTester
{
	int cell, courtyard, cafeteria, showers, workshop, phoneBooth, visitingCell, kitchen, library;
	String name;
	public ActionTester(String string)
	{
		name = string;
		
		cell = 0;
		courtyard = 0;
		cafeteria = 0;
		showers = 0;
		workshop = 0;
		phoneBooth = 0;
		visitingCell =0;
		kitchen = 0;
		library = 0;
	}
	public int getCell() {
		return cell;
	}
	public void setCell(int cell) {
		this.cell = cell;
	}
	public int getCourtyard() {
		return courtyard;
	}
	public void setCourtyard(int courtyard) {
		this.courtyard = courtyard;
	}
	public int getCafeteria() {
		return cafeteria;
	}
	public void setCafeteria(int cafeteria) {
		this.cafeteria = cafeteria;
	}
	public int getShowers() {
		return showers;
	}
	public void setShowers(int showers) {
		this.showers = showers;
	}
	public int getWorkshop() {
		return workshop;
	}
	public void setWorkshop(int workshop) {
		this.workshop = workshop;
	}
	public int getPhoneBooth() {
		return phoneBooth;
	}
	public void setPhoneBooth(int phoneBooth) {
		this.phoneBooth = phoneBooth;
	}
	public int getVisitingCell() {
		return visitingCell;
	}
	public void setVisitingCell(int visitingCell) {
		this.visitingCell = visitingCell;
	}
	public int getKitchen() {
		return kitchen;
	}
	public void setKitchen(int kitchen) {
		this.kitchen = kitchen;
	}
	public int getLibrary() {
		return library;
	}
	public void setLibrary(int library) {
		this.library = library;
	}
}
