import java.awt.Color;
import java.awt.Graphics2D;

public class Graph extends CoordinateHandler implements BaseEntity{
	
	
	private final float maxXaxis,minXaxis;
	private final float maxYaxis,minYaxis;
	private final float scaleXaxis, scaleYaxis;
	
	public Graph(float scaleXaxis,float scaleYaxis){
		this.maxXaxis = 300/scale;
		this.minXaxis = -300/scale;
		
		this.maxYaxis = 300/scale;
		this.minYaxis = -300/scale;
		
		this.scaleXaxis = scaleXaxis;
		this.scaleYaxis = scaleYaxis ;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.setColor(new Color(220,220,220));
		
		for(float y = minYaxis;y<=maxYaxis;y+=scaleYaxis){
			g2d.drawLine((int)setXCoordinate(minXaxis), (int)setYCoordinate(y), (int)setXCoordinate(maxXaxis), (int)setYCoordinate(y));
		}
	
		for(float x = minXaxis;x<=maxXaxis;x+=scaleXaxis){
			g2d.drawLine((int)setXCoordinate(x), (int)setYCoordinate(minYaxis), (int)setXCoordinate(x), (int)setYCoordinate(maxYaxis));
		}
		
		g2d.setColor(new Color(0,0,0));
		
		
		//Y-axis
		g2d.drawLine((int)setXCoordinate(0), (int)setYCoordinate(minYaxis), (int)setXCoordinate(0), (int)setYCoordinate(maxYaxis));
			
		//X-axis
		g2d.drawLine((int)setXCoordinate(minXaxis), (int)setYCoordinate(0), (int)setXCoordinate(maxXaxis), (int)setYCoordinate(0));
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
