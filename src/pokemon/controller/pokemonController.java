package pokemon.controller;
import pokemon.model.Pokemon;
import java.util.List;
import java.util.ArrayList;

public class pokemonController 
{
	private List<Pokemon> pokedex;
	
	public List<Pokemon> getPokedex()
	{
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
	public void start()
	{
		
	}
}
