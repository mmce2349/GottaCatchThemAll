package pokemon.view;

import pokemon.controller.pokemonController;
import javax.swing.JFrame;

public class pokemonFrame extends JFrame
{
	private pokemonController appController;
	private pokemonPanel appPanel;
	
	public pokemonFrame(pokemonController appController)
	{
		super();
		this.appController = appController; 
		appPanel = new pokemonPanel(appController);
		setupFrame();
		
	}
	private void setupFrame()
	{
		this.setSize(500, 500);
		this.setTitle("Chatbot 2017");
		this.setContentPane(appPanel);
		this.setResizable(false);
		this.setVisible(true);
		
	}
}
