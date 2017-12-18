package pokemon.model;

public class Bulbasaur extends Pokemon implements Grass

{
	public Bulbasaur(int number, String name)
	{
		super(number, name);
	}
	
	public int Razorleaf(int damage)
	{
		int attack = -50;
		return attack; 
	}
	
	public int Synthesis(int health)
	{
		int heal = 25;
		return heal;
	}
	
	public int tackle(int damage)
	{
		int attack = -10;
		return attack; 
				
	}
}
