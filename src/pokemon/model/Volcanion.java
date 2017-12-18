package pokemon.model;

public class Volcanion extends Pokemon implements Water, comparable
{
	public Volcanion(int number, String name)
	{
		super(number, name);
	}
	
	public boolean IronDefense()
	{
		return true;
	}
	
	public int Hydropump(int erosion)
	{
		int damage = -55;
		return damage;
	}
	
	public int waterPulse(int erosion)
	{
		int damage = -20;
		return damage;
	}
	
}
