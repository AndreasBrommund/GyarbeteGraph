import java.awt.Color;
import java.awt.Graphics2D;


public class Dot extends CoordinateHandler implements BaseEntity{

	private float x;
	private float y; 
	
	private final int diameter = 11;
	
	public Dot(float x, float y){
		this.x = x;
		this.y = y;
			
		init();
	}
	
	@Override
	public void draw(Graphics2D g2d) {

		g2d.setColor(Color.DARK_GRAY);
		g2d.fillOval((int)setXCoordinate(x)-diameter/2, (int)setYCoordinate(y)-diameter/2, (int)diameter, (int)diameter);

		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
