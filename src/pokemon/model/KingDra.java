package pokemon.model;

public class KingDra extends Pokemon implements SeaDra
{
	public KingDra(int number, String name)
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
