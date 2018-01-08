package pokemon.view;

import pokemon.controller.pokemonController;

import java.awt.Color;

import javax.swing.*;

public class pokemonPanel extends JPanel
{
	private pokemonController appController; 
	private SpringLayout appLayout;
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
	private JComboBox pokedexDropdown;
	
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
		modifierField.setText(appController.getPokedex().get(index).getHealthPoints() + "");
		
	}
	public pokemonPanel(pokemonController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		
		evolvableBox = new JCheckBox();
		nameField = new JTextField("name");
		appLayout.putConstraint(SpringLayout.EAST, nameField, -223, SpringLayout.EAST, this);
		numberField = new JTextField("##");
		appLayout.putConstraint(SpringLayout.WEST, nameField, 0, SpringLayout.WEST, numberField);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -346, SpringLayout.EAST, this);
		attackField = new JTextField("ap");
		appLayout.putConstraint(SpringLayout.WEST, attackField, 82, SpringLayout.WEST, this);
		healthField = new JTextField("hp");
		appLayout.putConstraint(SpringLayout.WEST, healthField, 82, SpringLayout.WEST, this);
		modifierField = new JTextField("mod");
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, modifierField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, modifierField);
		appLayout.putConstraint(SpringLayout.EAST, modifierField, -259, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableBox, -6, SpringLayout.NORTH, modifierField);
		
		iconLabel = new JLabel("pokemon", new ImageIcon(getClass().getResource("/pokemon/view/images/pokemon-logo-black-transparent.png")), JLabel.CENTER);
		appLayout.putConstraint(SpringLayout.SOUTH, iconLabel, -6, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.EAST, iconLabel, 0, SpringLayout.EAST, evolvableBox);
		
		
		healthLabel = new JLabel("health");
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, 0, SpringLayout.SOUTH, healthLabel);
		attackLabel = new JLabel("Attack. ");
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, attackLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, healthLabel, -17, SpringLayout.NORTH, attackLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, 0, SpringLayout.SOUTH, attackLabel);
		nameLabel = new JLabel(" name");
		appLayout.putConstraint(SpringLayout.NORTH, nameField, -5, SpringLayout.NORTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, healthLabel);
		numberLabel = new JLabel("number");
		appLayout.putConstraint(SpringLayout.NORTH, numberLabel, 37, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 6, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.EAST, numberLabel, 0, SpringLayout.EAST, attackLabel);
		evolvableLabel = new JLabel("evolvable");
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 10, SpringLayout.EAST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolvableLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -6, SpringLayout.NORTH, evolvableLabel);
		modifierLabel = new JLabel("modifier");
		appLayout.putConstraint(SpringLayout.WEST, modifierLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, modifierField, 19, SpringLayout.EAST, modifierLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableLabel, -14, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.NORTH, modifierField, -5, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, modifierLabel, -10, SpringLayout.SOUTH, this);
		pokedexDropdown = new JComboBox();
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 6, SpringLayout.EAST, iconLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, 0, SpringLayout.SOUTH, iconLabel);
		clearButton = new JButton("Clear");
		appLayout.putConstraint(SpringLayout.WEST, clearButton, 66, SpringLayout.EAST, modifierField);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, -10, SpringLayout.SOUTH, this);
		saveButton = new JButton("save");
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, clearButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, modifierLabel);
		
		this.firstType = new JPanel();
		this.secondType = new JPanel();
		this.thirdType = new JPanel();
		this.fourthType = new JPanel();
		
	setupComboBox();	
	setupTypePanels();
	setupPanel();
	setupLayout();
	setupListeners();
	}
//	private void updatePokedexInfo(int index)
//	{
//		
//	}
	private void setupComboBox()
	{
		DefaultComboBoxModel pokemonModel = new DefaultComboBoxModel(appController.convertPokedex());
		pokedexDropdown.setModel(pokemonModel);
	}
	private void setupTypePanels()
	{
		
	}
	private void setupPanel()
	{
		this.setLayout(appLayout);
		
		this.setBackground(Color.RED);
		this.add(healthLabel);
		this.add(attackLabel);
		this.add(nameLabel);
		this.add(numberLabel);
		this.add(evolvableLabel);
		this.add(iconLabel);
		this.add(modifierLabel);
		this.add(modifierField);
		this.add(attackField);
		this.add(nameField);
		this.add(healthField);
		this.add(numberField);
		this.add(evolvableBox);
		this.add(pokedexDropdown);
		this.add(clearButton);
		this.add(saveButton);
		
		this.add(descriptionArea);
		this.add(typeArea);
		
		
		
	}
	
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
		
	}
}
