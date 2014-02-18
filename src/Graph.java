import java.awt.Color;
import java.awt.Graphics2D;

public class Graph extends CoordinateHandler implements BaseEntity{
	
	
	private float maxXaxis,minXaxis;
	private float maxYaxis,minYaxis;
	private final float originX, originY;
	
	public Graph(){
		
		originX = setXCoordinate(0);
		originY = setYCoordinate(0);
		
		init();
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		maxXaxis = 800/scale;
		minXaxis = -800/scale;
		
		maxYaxis = 800/scale;
		minYaxis = -800/scale;
		
		
		
		for(float y = 0;y<=maxYaxis;y+=scaleYaxis){
			g2d.setColor(new Color(220,220,220));
			g2d.drawLine((int)setXCoordinate(minXaxis), (int)setYCoordinate(y), (int)setXCoordinate(maxXaxis), (int)setYCoordinate(y));
			g2d.drawLine((int)setXCoordinate(minXaxis), (int)setYCoordinate(y*-1), (int)setXCoordinate(maxXaxis), (int)setYCoordinate(y*-1));
			
			g2d.setColor(new Color(0,0,0));
			g2d.drawString(Integer.toString((int)y),(int)setXCoordinate(0), (int)setYCoordinate(y));
			g2d.drawString(Integer.toString((int)y),(int)setXCoordinate(0), (int)setYCoordinate(y*-1));
		}
	
		for(float x = 0;x<=maxXaxis;x+=scaleXaxis){
			g2d.setColor(new Color(220,220,220));
			g2d.drawLine((int)setXCoordinate(x), (int)setYCoordinate(minYaxis), (int)setXCoordinate(x), (int)setYCoordinate(maxYaxis));
			g2d.drawLine((int)setXCoordinate(x*-1), (int)setYCoordinate(minYaxis), (int)setXCoordinate(x*-1), (int)setYCoordinate(maxYaxis));
			g2d.setColor(new Color(0,0,0));
			g2d.drawString(Integer.toString((int)x),(int)setXCoordinate(x), (int)setYCoordinate(0));
			g2d.drawString(Integer.toString((int)x),(int)setXCoordinate(x*-1), (int)setYCoordinate(0));
		}
		
		g2d.setColor(new Color(0,0,0));
		
		//Draw line rectangle border
		g2d.drawRect(0, 0, 543, 590);

		//Y-axis
		g2d.drawLine((int)originX, (int)setYCoordinate(minYaxis), (int)originX, (int)setYCoordinate(maxYaxis));
			
		//X-axis
		g2d.drawLine((int)setXCoordinate(minXaxis), (int)originY, (int)setXCoordinate(maxXaxis), (int)originY);
	}
	public float getMaxYaxis() {
		return maxYaxis;
	}

	public float getMinYaxis() {
		return minYaxis;
	}

	public float getMaxXaxis() {
		return maxXaxis;
	}

	public float getMinXaxis() {
		return minXaxis;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
