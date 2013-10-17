import java.awt.Color;
import java.awt.Graphics2D;


public class LinearEquation extends CoordinateHandler implements BaseEntity{



	private final Graph graph;
	
	private final Color color; 
	private float k,m;
	
	public LinearEquation(float k,float m, Graph graph, Color color){
		this.k = k;
		this.m = m;
		this.graph = graph;
		this.color = color;
		
		init();
	}
	
	public LinearEquation(float x_1, float y_1, float x_2, float y_2,  Graph graph, Color color){
		this.k = calcK(x_1, y_1, y_2, x_2);
		this.m = calcM(x_1, y_1, this.k);
		this.graph = graph;
		this.color = color;
		init();
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		for(float x = graph.getMinXaxis()*2;x <= graph.getMaxXaxis()*2;x+=0.0001){
			
			float y = k*x+m;
			
			if(y >= graph.getMinYaxis()&&y <= graph.getMaxYaxis()){
				g2d.drawLine((int)setXCoordinate(x), (int)setYCoordinate(y), (int)setXCoordinate(x), (int)setYCoordinate(y));
			}
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	private float calcK(float x_1, float y_1, float y_2, float x_2){
		return (y_2-y_1)/(x_2-x_1);
	}
	private float calcM(float x, float y, float k){
		return (y-k*x);
	}
	public boolean testEquation(LinearEquation linearEquation){
		if(getM() == linearEquation.getM() && getK() == linearEquation.getK()){
			return true;
		}else{
			return false;
		}
		
	}
	public float getK() {
		return k;
	}
	public float getM() {
		return m;
	}
}
