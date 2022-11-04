import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class gamePrep extends JFrame implements KeyListener, ActionListener {

	
	
	private character1 Character1;
	
	private character2[] Character2 = new character2[3];
	
	private character2[] Character2_secondRow = new character2[3];
	
	private backgroundImage backgroundImage;
	
	private lava Lava;
	
	
	
	
	

	
	
	// graphic elements
	
	private Container content;
	
	private JLabel character1Label, backgroundLabel, lavaLabel;
	
	private JLabel[] character2Label = new JLabel[3], character2_secondRowLabel = new JLabel[3];
	
	private ImageIcon character1Image, character2Image, backgroundImg, lavaImg;;
	
	private JButton startButton;
	
	private JButton visibilityButton;
	
	
	
	
	public gamePrep() {
		
		
		// set character 1
		
		Character1 = new character1();
		
		Character1.setX(350);
		
		Character1.setY(700);
		
		Character1.setHeight(80);
		
		Character1.setWidth(80);
		
		Character1.setImage("girlRun.gif");
		
		Character1.updateRectangleSize();
		
		Character1.updateRectanglePosition();
		
		// character 2
		
		
		Character2[0] = new character2();
		
		Character2[0].setY(600);
		
		Character2[0].setX(0);
		
		Character2[0].setHeight(65);
		
		Character2[0].setWidth(65);
		
		Character2[0].setImage("Ghost.gif");
		
		Character2[0].setCharacter1(Character1);
		
		Character2[0].updateRectangleSize();
		
		Character2[0].updateRectanglePosition();
		
		// 2 / 1
		
        Character2[1] = new character2();
		
		Character2[1].setY(Character2[0].getY());
		
		Character2[1].setX(Character2[0].getX() - 350);
		
		Character2[1].setHeight(65);
		
		Character2[1].setWidth(65);
		
		Character2[1].setImage("Ghost.gif");
		
		Character2[1].setCharacter1(Character1);
		
		Character2[1].updateRectangleSize();
		
		Character2[1].updateRectanglePosition();
		
		
		
		// 2 / 2
		
		    Character2[2] = new character2();
			
			Character2[2].setY(Character2[0].getY());
			
			Character2[2].setX(Character2[1].getX() - 350);
			
			Character2[2].setHeight(65);
			
			Character2[2].setWidth(65);
			
			Character2[2].setImage("Ghost.gif");
			
			Character2[2].setCharacter1(Character1);
			
			Character2[2].updateRectangleSize();
			
			Character2[2].updateRectanglePosition();
			
			
			// Second row of ghosts 
			
			
			for (int i = 0; i < 3; i++) {
				
				Character2_secondRow[i] = new character2();
				
				if (i == 0) {
					
					Character2_secondRow[i].setY(400);
					
					Character2_secondRow[i].setX(0);
					
					
				} else {
					
					Character2_secondRow[i].setY(Character2_secondRow[0].getY());
					
					Character2_secondRow[i].setX(Character2_secondRow[1].getX() - 350);
				}
				
				
				
				Character2_secondRow[i].setHeight(Character2[0].getHeight());
				
				Character2_secondRow[i].setWidth(Character2[0].getWidth());
				
				Character2_secondRow[i].setImage(Character2[0].getImage());
				
				Character2_secondRow[i].setCharacter1(Character1);
				
				Character2_secondRow[i].updateRectangleSize();
				
				Character2_secondRow[i].updateRectanglePosition();
				
				
			}
		
		
		//
		
		backgroundImage = new backgroundImage();
		
		backgroundImage.setHeight(800);
		
		backgroundImage.setWidth(900);
		
		backgroundImage.setImage("Darkterrain.jpg");
		
		
		// set up second background image : Water / Lava
		
		Lava = new lava();
		
		Lava.setHeight(250);
		
		Lava.setWidth(900);
		
		Lava.setY(20);
		
		
		Lava.setImage("Lava.gif");
		
		
		
		
		
	// set up the screen
		
		setSize(gameProperties.screen_width, gameProperties.screen_height);
		
		content = getContentPane();
		
		content.setBackground(Color.GRAY);
		
		
		setLayout(null);
		
		
		// graphic elements added to the screen
		
		character1Label  = new JLabel();
		
		character1Image = new ImageIcon(getClass().getResource(Character1.getImage()));
		
		character1Label.setIcon(character1Image);
		
		character1Label.setSize(Character1.getWidth(), Character1.getHeight());
		
		character1Label.setLocation(Character1.getX(), Character1.getY());
		
		
		for (int i = 0 ; i < 3; i ++) {
			
			
			Character2[i].setCharacter1Label(character1Label);
			
			Character2_secondRow[i].setCharacter1Label(character1Label);
			
		}
		
	
		
		
		
		
		
		// graphic elements for character2
		
		character2Label[0] = new JLabel();
		
		
		character2Image = new ImageIcon(getClass().getResource(Character2[0].getImage()));
		
		character2Label[0].setIcon(character2Image);
		
		character2Label[0].setSize(Character2[0].getWidth(), Character2[0].getHeight());
		
		character2Label[0].setLocation(Character2[0].getX(), Character2[0].getY());
		
		Character2[0].setCharacter2Label(character2Label[0]);
		
		// ----------------------
		
		character2Label[1] = new JLabel();
		
		character2Label[1].setIcon(character2Image);
		
		character2Label[1].setSize(Character2[1].getWidth(), Character2[1].getHeight());
		
		character2Label[1].setLocation(Character2[1].getX(), Character2[1].getY());
		
		Character2[1].setCharacter2Label(character2Label[1]);
		
		// -------------
		
        character2Label[2] = new JLabel();
		
		character2Label[2].setIcon(character2Image);
		
		character2Label[2].setSize(Character2[1].getWidth(), Character2[1].getHeight());
		
		character2Label[2].setLocation(Character2[1].getX(), Character2[1].getY());
		
		Character2[2].setCharacter2Label(character2Label[2]);
		
		
		// Label for second row of ghosts
		
		
		for (int i = 0; i < 3; i++) {
			
			
			character2_secondRowLabel[i] = new JLabel();
			
			character2_secondRowLabel[i].setIcon(character2Image);
			
			character2_secondRowLabel[i].setSize(Character2[0].getWidth(), Character2[2].getHeight());
			
			character2_secondRowLabel[i].setLocation(Character2_secondRow[0].getX(), Character2_secondRow[0].getY());
			
			Character2_secondRow[i].setCharacter2Label(character2_secondRowLabel[i]);
			
			
		}
		
		
		//background label
		
		backgroundLabel = new JLabel();
		
		backgroundImg = new ImageIcon(getClass().getResource(backgroundImage.getImage()));
		
		backgroundLabel.setIcon(backgroundImg);
		
		backgroundLabel.setSize(backgroundImage.getWidth(), backgroundImage.getHeight());
		
		
		
		
		//second background label
		
		lavaLabel  = new JLabel();
		
		lavaImg = new ImageIcon(getClass().getResource(Lava.getImage()));
		
		lavaLabel.setIcon(lavaImg);
		
		lavaLabel.setSize(Lava.getWidth(), Lava.getHeight());
		
		
		
		// add a start button
		
		
		startButton = new JButton("start");
		
		startButton.setSize(100, 100);
		
		startButton.setLocation(gameProperties.screen_width - 120, gameProperties.screen_height - 180);
		
		startButton.setFocusable(false);
		
		for (int i = 0 ; i < 3;  i++) {
			
			Character2[i].setStartButton(startButton);
			
			Character2_secondRow[i].setStartButton(startButton);
			
		}
		
		
		
		
		
		// add hide button
		
		visibilityButton = new JButton("hide");
		
		visibilityButton.setSize(100,100);
		
		visibilityButton.setLocation(gameProperties.screen_width - 220, gameProperties.screen_height - 180);
		
		visibilityButton.setFocusable(false);
		
		
		// populate screen
		
		
		
		
		add(startButton);
		
		startButton.addActionListener(this);
		
		add(visibilityButton);
		
		visibilityButton.addActionListener(this);
		
		add(character1Label);
		
		
		for (int i = 0 ; i < 3 ; i++) {
			
			
			add(character2Label[i]);
			
			add(character2_secondRowLabel[i]);
		
		}
		
	
		add(lavaLabel);
		add(backgroundLabel);
		
		
		
		
		
	
		
		content.addKeyListener(this);
		
		content.setFocusable(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	
	public static void main(String args []){
		
		gamePrep myGame = new gamePrep();
		
		myGame.setVisible(true);
		
	
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	public void keyPressed(KeyEvent e) {
		
		
		int x = Character1.getX();
		
		int y = Character1.getY();
		
		
		
	if (e.getKeyCode() == KeyEvent.VK_UP) {
		
		y -= gameProperties.character_step;
		
		if (y + Character1.getHeight() <= 0) {
			
			y = gameProperties.screen_height;
		}
		
		
		
	} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		
		x -= gameProperties.character_step;
		
		if (x + Character1.getWidth() <= 0) {
			
			x = gameProperties.screen_width;
		}
		
	} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		
		
		y+=  gameProperties.character_step;
		
		
		if (y  >= gameProperties.screen_height) {
			
			
			y = -1 * Character1.getHeight();
			
		}
		
		
	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		
		
		x += gameProperties.character_step;
		
		
		if (x >= gameProperties.screen_width) {
			
			
			x = -1 * Character1.getWidth();
			
		}
		
		
	} else {
		
		
		
		System.out.println("Invalid");
		
	}
	
	Character1.setX(x);
	
	Character1.setY(y);
	
	
	Character1.updateRectanglePosition();
	
	character1Label.setLocation(Character1.getX(), Character1.getY());
	
	

		
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// 
		
		for ( int i  = 0 ; i < 3 ; i++) {
			
			
		if (e.getSource() == startButton) {
			
			if (Character2[i].getIsMoving()) {
				
				Character2[i].setIsMoving(false);
				
				Character2_secondRow[i].setIsMoving(false);
			
			} else {
				
				Character2[i].startMoving();
				
				Character2_secondRow[i].startMoving();
				
			
			}
			
		} else if (e.getSource() == visibilityButton) {
			
			
			
			if (Character2[i].getVisible()) {
				
				
				Character2[i].setVisible(false);
				
				Character2_secondRow[i].setVisible(false);
				
				
				character2Label[i].setVisible(Character2[i].getVisible());
				
				character2_secondRowLabel[i].setVisible(Character2_secondRow[i].getVisible());
				
				visibilityButton.setText("show");
				
				
			} else {
				
				Character2[i].setVisible(true);
				
				Character2_secondRow[i].setVisible(true);
				
				
				character2Label[i].setVisible(Character2[i].getVisible());
				
				character2_secondRowLabel[i].setVisible(Character2_secondRow[i].getVisible());
				
				
				visibilityButton.setText("hide");
			}
		}
		
		}
		
		
		
		
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
