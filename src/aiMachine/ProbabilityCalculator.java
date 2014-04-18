package aiMachine;

public class ProbabilityCalculator {
	
	public static double winChance(double base1, int random1, double base2, int random2)
	{
		int winCounter = 0;
		int loseCounter = 0;
		for(int i = 0; i<random1;i++)
		{
			for(int j = 0; j<random2; j++)
			{
				if(base1 + i > base2 + j)
				{
					winCounter++;
				}
				else
				{
					loseCounter++;
				}
			}
		}
		return winCounter/(winCounter + loseCounter);
	}

}
