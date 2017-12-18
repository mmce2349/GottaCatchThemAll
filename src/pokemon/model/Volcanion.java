package pokemon.model;

public class Volcanion extends Pokemon implements Water, Fire
{
	public Volcanion(int number, String name)
	{
		super(number, name);
	}
	//Water
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
	
	
	//Fire
	public int slash(int damage)
		{
			int attack = -10;
			return attack;
		}
		
	public int flamethrower(int burn)
		{
			int damage = -60;
			return damage;
		}
		
	public int ember(int burn)
		{
			int damage = -15;
			return damage; 
		}
	
	
}
