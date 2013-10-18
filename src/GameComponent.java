import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GameComponent extends Canvas{
	
	private Game game;
	
	//Width 543
	//Height 590
	
	//Graphic stuff
	private Graphics2D g2d;
	private BufferedImage backbuffer;
		
	//Objects here 
	private Graph graph;
	private LinearEquation linearEquation;
		
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
		graph = new Graph(1f,1f);
		//linearEquation = new LinearEquation(2f, 0f, graph, Color.BLACK);
		linearEquation = new LinearEquation(1f,-2f, graph, Color.BLUE);
		game.getEquation().setText(linearEquation.getEquation());
	}
	
	private void draw(Graphics2D g2d){

		
		graph.draw(g2d);
		linearEquation.draw(g2d);
	}
	public void uppdateScreen(){
		run();
	}

	public void newPoint(float x, float y){
		x = graph.getXCoordinate(x);
		y = graph.getYCoordinate(y);
		
		System.out.println("x="+x+"y="+y);
	}
}
