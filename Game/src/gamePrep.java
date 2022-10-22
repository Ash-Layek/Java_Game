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
	
	private character2[] Character2 = new character2[2];
	
	private backgroundImage backgroundImage;
	
	
	// graphic elements
	
	private Container content;
	
	private JLabel character1Label, backgroundLabel;
	
	private JLabel[] character2Label = new JLabel[2];
	
	private ImageIcon character1Image, character2Image, backgroundImg;
	
	private JButton startButton;
	
	private JButton visibilityButton;
	
	
	
	
	public gamePrep() {
		
		
		// set character 1
		
		Character1 = new character1();
		
		Character1.setX(350);
		
		Character1.setY(380);
		
		Character1.setHeight(112);
		
		Character1.setWidth(128);
		
		Character1.setImage("catgif.gif");
		
		Character1.updateRectangleSize();
		
		Character1.updateRectanglePosition();
		
		// character 2
		
		
		Character2[0] = new character2();
		
		Character2[0].setY(50);
		
		Character2[0].setX(0);
		
		Character2[0].setHeight(240);
		
		Character2[0].setWidth(240);
		
		Character2[0].setImage("wolf_run.gif");
		
		Character2[0].setCharacter1(Character1);
		
		Character2[0].updateRectangleSize();
		
		Character2[0].updateRectanglePosition();
		
		// 2 / 1
		
        Character2[1] = new character2();
		
		Character2[1].setY(50);
		
		Character2[1].setX(300);
		
		Character2[1].setHeight(240);
		
		Character2[1].setWidth(240);
		
		Character2[1].setImage("wolf_run.gif");
		
		Character2[1].setCharacter1(Character1);
		
		Character2[1].updateRectangleSize();
		
		Character2[1].updateRectanglePosition();
		
		
		
		
		//
		
		backgroundImage = new backgroundImage();
		
		backgroundImage.setHeight(1200);
		
		backgroundImage.setWidth(800);
		
		backgroundImage.setImage("landscape.jpg");
		
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
		
		Character2[0].setCharacter1Label(character1Label);
		
		Character2[1].setCharacter1Label(character1Label);
		
		
		
		
		
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
		
		
		//background label
		
		backgroundLabel = new JLabel();
		
		backgroundImg = new ImageIcon(getClass().getResource(backgroundImage.getImage()));
		
		backgroundLabel.setIcon(backgroundImg);
		
		backgroundLabel.setSize(gameProperties.screen_width, gameProperties.screen_height);
		
		
		
		
		// add a start button
		
		
		startButton = new JButton("start");
		
		startButton.setSize(100, 100);
		
		startButton.setLocation(gameProperties.screen_width - 120, gameProperties.screen_height - 180);
		
		startButton.setFocusable(false);
		
		Character2[0].setStartButton(startButton);
		
		Character2[1].setStartButton(startButton);
		
		
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
		add(character2Label[0]);
		
		add(character2Label[1]);
		
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
		
		if (e.getSource() == startButton) {
			
			if (Character2[0].getIsMoving()) {
				
				Character2[0].setIsMoving(false);
				
				Character2[1].setIsMoving(false);
				
			} else {
				
				Character2[0].startMoving();
				
				Character2[1].startMoving();
			}
			
		} else if (e.getSource() == visibilityButton) {
			
			
			
			if (Character2[0].getVisible()) {
				
				
				Character2[0].setVisible(false);
				
				Character2[1].setVisible(false);
				
				character2Label[0].setVisible(Character2[0].getVisible());
				
				character2Label[1].setVisible(Character2[1].getVisible());
				
				visibilityButton.setText("show");
				
				
			} else {
				
				Character2[0].setVisible(true);
				
				Character2[1].setVisible(true);
				
				character2Label[0].setVisible(Character2[0].getVisible());
				
				character2Label[1].setVisible(Character2[1].getVisible());
				
				visibilityButton.setText("hide");
			}
		}
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
