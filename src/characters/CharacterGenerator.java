package characters;

import java.util.Random;

public class CharacterGenerator
{
	static Random random;
	static String[] name;
	static String[] surname;

	public CharacterGenerator()
	{
		
		
	}
	
	public static String generateName()
	{
		random = new Random();
		String[] name = new String[]{"jack", "nigel", "nick", "boogie", "jim", "george", "nicolas", "sam", "logan", "matt", "jeff", "rich", "stephan", "oberyn", "dan", "rock", "lester", "moe", "christopher"};
		String[] surname = new String[]{"fisher", "frost", "reacher", "mountain", "foreman", "lester", "scheem", "rockwell", "nitz", "ledger", "sordid", "ham", "tuck", "spell", "delay", "klegane"};
		
		String fullName = name[random.nextInt(name.length)] + " " + surname[random.nextInt(surname.length)];
		return fullName;
	}
	
}
