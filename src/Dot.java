import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JLabel;


public class Dot extends CoordinateHandler implements BaseEntity{

	private float x;
	private float y; 
	
	private String cordianates;
	
	private final int diameter = 11;
	
	private Color color = Color.BLACK;
	
	public Dot(float x, float y){
		this.x = x;
		this.y = y;
			
		cordianates = "("+this.x+" , "+this.y+")";
		
		init();
	}
	
	@Override
	public void draw(Graphics2D g2d) {

		g2d.setColor(color);
		g2d.fillOval((int)setXCoordinate(x)-diameter/2, (int)setYCoordinate(y)-diameter/2, (int)diameter, (int)diameter);
		
		g2d.drawString(cordianates, (int)setXCoordinate(x+0.1f), (int)setYCoordinate(y+0.1f));

		
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	public float getPosX() {
		return x;
	}

	public float getPosY() {
		return y;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
