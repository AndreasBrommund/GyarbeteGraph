import java.awt.Color;
import java.awt.Graphics2D;

public class Graph extends CoordinateHandler implements BaseEntity{
	
	
	private final float maxXaxis,minXaxis;
	private final float maxYaxis,minYaxis;
	private final float originX, originY;
	private final float scaleXaxis, scaleYaxis;
	
	public Graph(float scaleXaxis,float scaleYaxis){
		this.maxXaxis = 300/scale;
		this.minXaxis = -300/scale;
		
		this.maxYaxis = 300/scale;
		this.minYaxis = -300/scale;
		
		this.scaleXaxis = scaleXaxis;
		this.scaleYaxis = scaleYaxis ;
		
		originX = setXCoordinate(0);
		originY = setYCoordinate(0);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(new Color(220,220,220));
		
		for(float y = 0;y<=maxYaxis;y+=scaleYaxis){
			g2d.drawLine((int)setXCoordinate(minXaxis), (int)setYCoordinate(y), (int)setXCoordinate(maxXaxis), (int)setYCoordinate(y));
		}
		for(float y = 0;y>=minYaxis;y-=scaleYaxis){
			g2d.drawLine((int)setXCoordinate(minXaxis), (int)setYCoordinate(y), (int)setXCoordinate(maxXaxis), (int)setYCoordinate(y));
		}
	
		for(float x = 0;x<=maxXaxis;x+=scaleXaxis){
			g2d.drawLine((int)setXCoordinate(x), (int)setYCoordinate(minYaxis), (int)setXCoordinate(x), (int)setYCoordinate(maxYaxis));
		}
		for(float x = 0;x>=minXaxis;x-=scaleXaxis){
			g2d.drawLine((int)setXCoordinate(x), (int)setYCoordinate(minYaxis), (int)setXCoordinate(x), (int)setYCoordinate(maxYaxis));
		}
		
		g2d.setColor(new Color(0,0,0));
		
		//Draw line rectangle border
		g2d.drawRect(0, 0, 543, 590);

		//Y-axis
		g2d.drawLine((int)originX, (int)setYCoordinate(minYaxis), (int)originX, (int)setYCoordinate(maxYaxis));
			
		//X-axis
		g2d.drawLine((int)setXCoordinate(minXaxis), (int)originY, (int)setXCoordinate(maxXaxis), (int)originY);
	}

	@Override
	public void uppdate() {
		
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
}
