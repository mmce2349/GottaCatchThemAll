package pokemon.model;

public class Volcanion extends Pokemon implements Water, Comparable
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
	
	public int WaterPulse(int erosion)
	{
		int damage = -20;
		return damage;
	}
	
	Comparable<Fire>//figure this out. 
	
}
