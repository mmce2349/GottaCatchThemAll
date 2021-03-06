package pokemon.controller;
import pokemon.model.Pokemon;
import pokemon.model.*;
import java.util.List;
import java.util.ArrayList;
import pokemon.view.*;

public class pokemonController 
{
	private List<Pokemon> pokedex;
	private pokemonFrame appFrame;
	
	public pokemonController()
	{
		this.pokedex = new ArrayList<Pokemon>();
		buildPokedex();
		
		appFrame = new pokemonFrame(this);
	}
	private void buildPokedex()
	{
		pokedex.add(new Squirtle());
		pokedex.add(new SeaDra("mmm seahorse"));
	
	}
	public List<Pokemon> getPokedex()
	{
		pokedex.add(new Squirtle());
		pokedex.add(new Bulbasaur());
		pokedex.add(new Charmander());
		pokedex.add(new KingDra());
		pokedex.add(new SeaDra());
		pokedex.add(new Volcanion());
	
		return pokedex;
	}
	
	public boolean isValidInteger(String input)
	{
		boolean valid= false;
		
		try
		{
			Integer.parseInt(input);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			
		}
		return valid;
	}
	
	public boolean isValidDouble(String input)
	{
		boolean valid = false;
		
		try 
		{
			Double.parseDouble(input);
			valid = true;
		}
		
		catch(NumberFormatException error)
		{
			
		}
		return valid; 
	}
	public String [] convertPokedex()
	{
		String [] names = new String [pokedex.size()];
		for(int index = 0; index < pokedex.size(); index++)
		{
			names[index] = pokedex.get(index).getName();
		}
		return names;
	}
	public void updateSelected(int selection, int health, int attack, boolean evolve, double modify, String name)
	{
		Pokemon selected = pokedex.get(selection);
		
		selected.setAttackPoints(attack);
		selected.setCanEvolve(evolve);
		selected.setEnhancementModifier(modify);
		selected.setName(name);
		selected.setHealthPoints(health);
		
		FileController.savePokemonToFile((ArrayList<Pokemon>) pokedex);
	}
	public void start()
	{
		
	}
	
}
