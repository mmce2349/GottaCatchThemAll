package pokemon.view;

import pokemon.controller.pokemonController;

import java.awt.Color;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		
		descriptionArea.setText(appController.getPokedex().get(index).toString());
		typeArea.setText("");
		
		for (String current: appController.getPokedex().get(index).getPokemonTypes())
		{
			typeArea.append(current + "\n");
		}
		
	}
	public pokemonPanel(pokemonController appController)
	{
		super();
		this.appController = appController;
		
		appLayout = new SpringLayout();
		
		evolvableBox = new JCheckBox();
		nameField = new JTextField("name");
	
		numberField = new JTextField("##");
	
		attackField = new JTextField("ap");
		healthField = new JTextField("hp");
		modifierField = new JTextField("mod");
		
		iconLabel = new JLabel("Pokemon", new ImageIcon(getClass().getResource("Logo.png")), JLabel.CENTER);
		
		
		healthLabel = new JLabel("health");
		attackLabel = new JLabel("Attack. ");
		nameLabel = new JLabel(" name");

		numberLabel = new JLabel("number");
	
		evolvableLabel = new JLabel("evolvable");
		modifierLabel = new JLabel("modifier");
		pokedexDropdown = new JComboBox();
	
		clearButton = new JButton("Clear");
	
		saveButton = new JButton("save");
		
		
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
	
	private void updateImage()
	{
		String path = "/pokemon/view/images/";
		String defaultName = "Logo";
		String name = pokedexDropdown.getSelectedItem().toString();
		String extension = ".png";
		ImageIcon pokemonIcon;
		
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension));
			
		}
		catch (NullPointerException missingImageFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		
		iconLabel.setIcon(pokemonIcon);
	}
	private void setupComboBox()
	{
		DefaultComboBoxModel pokemonModel = new DefaultComboBoxModel(appController.convertPokedex());
		pokedexDropdown.setModel(pokemonModel);
	}
	private void setupTypePanels()
	{
		
	}
	private void updateTypePanels()
	{
		String [] types = appController.getPokedex().get(pokedexDropdown.getSelectedIndex()).getPokemonTypes();
		if (types[0].equals("Grass"))
		{
			firstType.setBackground(Color.GREEN);
		}
		else if(types[0].equals("Fire"))
		{
			firstType.setBackground(Color.RED);
		}
		else if(types[0].equals("Water"))
		{
			firstType.setBackground(Color.BLUE);
		}
		else
		{
			firstType.setBackground(Color.WHITE);
		}
		
		if(types.length > 1)
		{
			if(types [1].equals("Grass"))
			{
				secondType.setBackground(Color.GREEN);
			}
			else if(types [1].equals("Fire"))
			{
				secondType.setBackground(Color.RED);
			}
			else if(types [1].equals("Water"))
			{
				secondType.setBackground(Color.BLUE);
			}
			else
			{
				secondType.setBackground(Color.WHITE);
			}
			if(types.length == 3)
			{
				
			}
		}
		
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
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 6, SpringLayout.EAST, clearButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.WEST, clearButton, 66, SpringLayout.EAST, modifierField);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.SOUTH, pokedexDropdown, 0, SpringLayout.SOUTH, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, modifierLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.WEST, modifierField, 19, SpringLayout.EAST, modifierLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableLabel, -14, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.NORTH, modifierField, -5, SpringLayout.NORTH, modifierLabel);
		appLayout.putConstraint(SpringLayout.SOUTH, modifierLabel, -10, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.WEST, evolvableBox, 10, SpringLayout.EAST, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, evolvableLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackLabel, -6, SpringLayout.NORTH, evolvableLabel);
		appLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, attackLabel);
		appLayout.putConstraint(SpringLayout.WEST, attackLabel, 10, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, attackField, 0, SpringLayout.SOUTH, attackLabel);
		appLayout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, modifierField);
		appLayout.putConstraint(SpringLayout.EAST, attackField, 0, SpringLayout.EAST, modifierField);
		appLayout.putConstraint(SpringLayout.EAST, modifierField, -259, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, evolvableBox, -6, SpringLayout.NORTH, modifierField);
		appLayout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.WEST, healthField, 82, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, healthField, -7, SpringLayout.NORTH, attackField);
		appLayout.putConstraint(SpringLayout.WEST, attackField, 82, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, numberLabel, -39, SpringLayout.NORTH, clearButton);
		appLayout.putConstraint(SpringLayout.WEST, pokedexDropdown, 131, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.EAST, pokedexDropdown, -22, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, numberLabel);
		appLayout.putConstraint(SpringLayout.NORTH, numberField, -5, SpringLayout.NORTH, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberField, 16, SpringLayout.EAST, numberLabel);
		appLayout.putConstraint(SpringLayout.WEST, numberLabel, 52, SpringLayout.EAST, attackField);
		appLayout.putConstraint(SpringLayout.SOUTH, nameField, 0, SpringLayout.SOUTH, nameLabel);
		appLayout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, healthField);
		appLayout.putConstraint(SpringLayout.NORTH, iconLabel, 10, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, iconLabel, 183, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, iconLabel, -165, SpringLayout.NORTH, numberField);
		appLayout.putConstraint(SpringLayout.EAST, iconLabel, -186, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, numberField, -104, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, nameField, 288, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, this);
	}
	private void setupListeners()
	{
		pokedexDropdown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
			int selectedPokemonIndex = pokedexDropdown.getSelectedIndex();
			updatePokedexInfo(selectedPokemonIndex);
			updateImage();
			updateTypePanels();
			repaint();
			}
		});
		
		saveButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent click)
			{
				if(appController.isValidInteger(attackField.getText()) && appController.isValidInteger(healthField.getText()) && appController.isValidDouble(modifierField.getText()))
				{
					int selected = pokedexDropdown.getSelectedIndex();
					int health = Integer.parseInt(healthField.getText());
					int attack = Integer.parseInt(attackField.getText());
					double modifier = Double.parseDouble(modifierField.getText());
					String name = nameField.getText();
					boolean evolvable = evolvableBox.isSelected();
					
					//send to the controller to modify the Pokemon.
					appController.updateSelected(selected, health, attack, evolvable, modifier, name);
				}
			}
				});
	}
	
}
