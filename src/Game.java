import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;


public class Game extends JFrame{
	//Basic stuff
	public static int screenWidth = 600;	 
	public static int screenHeight = 720;	
	public static String title = "Graph";
	
	//Loop
	private boolean run;
	
	//Graphic stuff
	private Graphics2D g2d;
	private BufferedImage backbuffer;
	
	//Objects here 
	private Graph graph;
	private LinearEquation linearEquation;
	
	public static void main(String[]args){
		new Game();
	}
	public Game(){
		super(title);
		setSize(screenWidth, screenHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		init();
		
		run = true;
		
		gameLoop();
	}
	private void gameLoop(){
		while(run){
			uppdate();
			render();
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void render(){
		
		if(backbuffer == null){
			backbuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			g2d = backbuffer.createGraphics();
		}
		
		g2d.setColor(Color.WHITE);
		g2d.fill(new Rectangle(0,0,getWidth()-1,getHeight()-1));
		
		draw(g2d);
	}
	public void paint(Graphics g){
		g.drawImage(backbuffer, 0, 0, this);
	}
	
	private void init(){
		graph = new Graph(1,1);
		linearEquation = new LinearEquation(7f, 7f, graph, Color.BLACK);
	}
	
	private void draw(Graphics2D g2d){
		
		graph.draw(g2d);
		linearEquation.draw(g2d);
		
	}
	
	
	private void uppdate(){
		graph.uppdate();
		linearEquation.uppdate();
	}
}
