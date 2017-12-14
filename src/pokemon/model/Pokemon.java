package pokemon.model;

public abstract class Pokemon 
{
	private int healthPoints;
	private int attackPoints;
	private double enhancementModifier; 
	private int number; 
	private String name;
	private boolean canEvolve; 
	
	public Pokemon( int number, String name)
	{
		this.name = name;
		this.number = number; 
	}
	
	public final String getPokemonTypes()
	{
		String pokemonTypes = "This pokemon has the following types: \n";
		Class<?> [] types = getClass().getInterfaces();
		String [] pokeTypes = new String[types.length];
		
		for(int index = 0; index < types.length; index++)
		{
			String currentInterface = types[index].getCanonicalName();
			
			pokeTypes[index] = currentInterface; 
		}
		
		for(String current : pokeTypes)
		{
			String temp = current.replace(this.getClass().getPackage().getName() + ".", "");
			pokemonTypes += temp + "\n";
		}
		return pokemonTypes; 
	}
	
	public String toString()
	{
		String description = "Hi, I am " + name + ", and my HP is " + healthPoints;
		return description; 
	}
	
	public String getPokemonInformation()
	{
		String pokemonInfo = "This pokemon is of type: " + this.getClass().getSimpleName(); 
		
		return pokemonInfo;
	}
}
