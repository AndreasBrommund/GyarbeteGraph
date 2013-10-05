import java.awt.Color;
import java.awt.Graphics2D;


public class LinearEquation extends CoordinateHandler implements BaseEntity{

	
	private Graph graph;
	
	private final Color color; 
	private float k,m;
	
	public LinearEquation(float k,float m, Graph graph, Color color){
		this.k = k;
		this.m = m;
		this.graph = graph;
		this.color = color;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		for(float x = graph.getMinXaxis();x <= graph.getMaxXaxis();x+=0.001){
			
			float y = k*x+m;
			
			if(y >= graph.getMinYaxis()&&y <= graph.getMaxYaxis()){
				g2d.drawLine((int)setXCoordinate(x), (int)setYCoordinate(y), (int)setXCoordinate(x), (int)setYCoordinate(y));
			}
		}
	}

	@Override
	public void uppdate() {
		
		
	}

}
