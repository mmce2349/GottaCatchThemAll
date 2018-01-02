package pokemon.view;

import pokemon.controller.pokemonController;
import javax.swing.*;

public class pokemonPanel extends JPanel
{
	private pokemonController appController; 
	
	private JLabel healthLabel;
	private JLabel attackLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel evolvableLabel;
	private JLabel modifierLabel;
	private JLabel iconLabel; 
	
	private JCheckBox evolvableBox;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField attackField;
	private JTextField  healthField;
	private JTextField modifierField;
	
	private JTextArea descriptionArea;
	private JTextArea typeArea;
	
	private JButton saveButton;
	private JButton clearButton;
	private JComboBox pokeexDropdown;
	
	private JPanel firstType;
	private JPanel secondType;
	private JPanel thirdType;
	private JPanel fourthType; 
	
	private void updatePokedexInfo(int index)
	{
		nameField.setText(appController.getPokedex().get(index).getName());
		evolvableBox.setSelected(appController.getPokedex().get(index).isCanEvolve());
		numberField.setText(appController.getPokedex().get(index).getNumber() + "");
		attackField.setText(appController.getPokedex().get(index).getAttackPoints() + "");
		healthField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		modifierField.setText(appController.getPokdex().get(index).getHealthPoints() + "");
		
	}
}
