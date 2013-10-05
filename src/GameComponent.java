import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

	

public class GameComponent extends Canvas{
	
	private Game game;
	
	//Loop
	private boolean run;
		
	//Graphic stuff
	private Graphics2D g2d;
	private BufferedImage backbuffer;
		
	//Objects here 
	private Graph graph;
	private LinearEquation linearEquation;
	
	public GameComponent(Game game) {
		run = true;
		this.game = game;
		init();
		
		gameLoop();
	}
	
	private void gameLoop(){
		//while(run){
			uppdate();
			render();
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
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
		graph = new Graph(1,1);
		linearEquation = new LinearEquation(2f, 0f, graph, Color.BLACK);
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