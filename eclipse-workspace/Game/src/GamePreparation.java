import java.awt.Button;
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

public class GamePreparation extends JFrame implements KeyListener, ActionListener {

	
	 private Character1 character1;
	 
	 
	 private Container content;
	 
	 private JLabel character1Label;
	 
	 private ImageIcon character1Img;
	 
	 private JButton startButton;
	 
	 
	 public GamePreparation() {
		 
		 
		 //setting up the character
		 
		 
		 character1 = new Character1();
		 
		 character1.setHeight(200);
		 
		 character1.setWidth(200);
		 
		 character1.setX(0);
		 
		 character1.setY(0);
		 
		 character1.setImage("Jotaro.gif");
		 
		 
		 
		 
		 s
		 //setting up the screen
		 
		 
		 
		 setSize(GameProperties.SCREEN_WIDTH, GameProperties.SCREEN_HEIGHT);
		 
		 content = getContentPane();
		 
		 content.setBackground(Color.black);
		 
		 setLayout(null);
		 
		 //initializing the character on the screen
		 
		 character1Label = new JLabel();
		 
		 character1Img = new ImageIcon(getClass().getResource(character1.getImage()));
		 
		 character1Label.setIcon(character1Img);
		 
		 character1Label.setSize(character1.getHeight(), character1.getWidth());
		 
		 character1Label.setLocation(character1.getX(), character1.getY());
		 
		 
		 
       // adding the button
		 
		 startButton  = new JButton("Start");
		 
		 startButton.setSize(100,100);
		 
		 startButton.setLocation(GameProperties.SCREEN_HEIGHT - 100, GameProperties.SCREEN_WIDTH);
		 
		 startButton.setFocusable(false);
		 
		//populate screen
		 
		 add(startButton);
		 
		 add(character1Label);
		 
		 
		 
		 content.addKeyListener(this);
		 
		 content.setFocusable(true);
		 
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 
	 }
	 
	 public static void main(String Args []) {
		 
		 GamePreparation myGame = new GamePreparation();
		 
		 myGame.setVisible(true);
		 
		 
		 
	 }
	 
	 @Override
	 
	 public void keyPressed(KeyEvent e) {
		 
		 int x = character1.getX();
		 
		 int y = character1.getY();
		 
		 
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			
			y -= GameProperties.SCREEN_HEIGHT;
			
			
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			
			y+= GameProperties.SCREEN_HEIGHT;
			
		}
		 
		 
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 
	
	
}
