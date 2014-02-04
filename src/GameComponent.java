import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class GameComponent extends Canvas{
	
	private Game game;
	
	//Width 543
	//Height 590
	//
	
	//Graphic stuff
	private Graphics2D g2d;
	private BufferedImage backbuffer;
		
	//Graph stuff
	private Graph graph;
	private LinearEquation linearEquation;
	private LinearEquation linearEquationUsers;
	
	//Dots 
	private Dot[] dot = new Dot[2];
	private short nextDotIndex = 0;
	
	public GameComponent(Game game) {
		this.game = game;
		init();
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		run();
	}
	
	private void run(){
		render();
		repaint();
	}
		
	private void render(){
		
		if(backbuffer == null){
			backbuffer = new BufferedImage(game.getWidth(), game.getHeight(), BufferedImage.TYPE_INT_RGB);
			g2d = backbuffer.createGraphics();
		}
		
		g2d.setColor(Color.WHITE);
		g2d.fill(new Rectangle(0,0,game.getWidth()-1,game.getHeight()-1));
		
		draw(g2d);
	}
	public void paint(Graphics g){
		g.drawImage(backbuffer, 0, 0, this);
	}
	
	private void init(){
		graph = new Graph();
		
		linearEquationUsers = new LinearEquation(-1000, -1000, -1000, -1000,graph, Color.RED);
		
		newGame();
	}
	
	private void draw(Graphics2D g2d){

		graph.draw(g2d);
		linearEquation.draw(g2d);
		
		
		linearEquationUsers.draw(g2d);
		
		for(Dot d:dot){
			if(d != null){
				d.draw(g2d);
			}
		}
		
		
	}
	private void newGame(){
		
		linearEquationUsers.setVisible(false);
		
		dot[0] = new Dot(-1000, -1000);
		dot[1] = new Dot(-1000, -1000);
		
		linearEquationUsers.setPoint1(dot[0]);
		linearEquationUsers.setPoint2(dot[1]);
		
		float k = (int) (Math.random()*5);
		
		switch ((int)(Math.random()*2)){
	
		case 0:
			k += 0.50;
			break;
	
		default:
			break;
		}
	
		if((int)(Math.random()*2)==0){
			k *= -1;
		}
		
		float m = (int) (Math.random()*5);
		
		/*switch ((int)(Math.random()*2)){
		
		case 0:
			m += 0.50;
			break;
	
		default:
			break;
		}*/

		
		if((int)(Math.random()*2)==0){
			m *= -1;
		}
		linearEquation = new LinearEquation(k, m, graph, Color.BLUE);
		game.getEquation().setText(linearEquation.getEquation());	
		
		uppdateScreen();
	}

	
	public void uppdateScreen(){
		run();
	}

	public void newPoint(float x, float y){
		x = rounding(graph.getXCoordinate(x));
		y = rounding(graph.getYCoordinate(y));
		
		Dot dot_before;

		if(x == dot[0].getPosX() && y == dot[0].getPosY()){
			dot[1].setColor(Color.BLACK);
			dot[0].setColor(Color.GRAY);
			nextDotIndex = 0;
		}else if(x == dot[1].getPosX() && y == dot[1].getPosY()){
			nextDotIndex = 1;
			dot[0].setColor(Color.BLACK);
			dot[1].setColor(Color.GRAY);
		}else{
		
			switch (nextDotIndex){
			case 0:
				dot_before = dot[0];
				
				dot[0] = new Dot(x, y);
				if(linearEquationUsers.setPoint1(dot[0])){
					nextDotIndex = 1;
					dot[0].setColor(Color.BLACK);
					if(dot[1] != null){
						dot[1].setColor(Color.GRAY);
					}
				}else{
					dot[0] = dot_before;
					JOptionPane.showMessageDialog(this,"De två X värdena kan inte var samma!", "X fel",JOptionPane.ERROR_MESSAGE);	
				}
				break;
			case 1:
				dot_before = dot[1];
				dot[1] = new Dot(x, y);
				if(linearEquationUsers.setPoint2(dot[1])){
					nextDotIndex = 0;
					linearEquationUsers.setVisible(true);
					dot[1].setColor(Color.BLACK);
					dot[0].setColor(Color.GRAY);
				}
				else{
					dot[1] = dot_before;
					JOptionPane.showMessageDialog(this,"De två X värdena kan inte var samma!", "X fel",JOptionPane.ERROR_MESSAGE);
				}
				break;
			}
		}
		
	}
	//Can get beater
	private float rounding(float number){
		return Math.round(number);
	}
	public void testEquation(){
		if(linearEquation.testEquals(linearEquationUsers)){
			JOptionPane.showMessageDialog(this,"Rätt svar!","Rätt!", JOptionPane.PLAIN_MESSAGE);
			if(JOptionPane.showConfirmDialog(this,"Vill du spela igen?","Spela igen",JOptionPane.YES_NO_OPTION)==0){
				newGame();
			}else{
				System.exit(3);
			}
		}else{
			JOptionPane.showMessageDialog(this,"Fel, testa igen!","Fel", JOptionPane.PLAIN_MESSAGE);  
		}		
	}
}
