import java.awt.Color;
import java.awt.Graphics2D;


public class LinearEquation extends CoordinateHandler implements BaseEntity{



	private final Graph graph;
	
	private final Color color; 
	private float k,m;
	
	private float x_1,x_2,y_1,y_2;
	private boolean haveCordinats = false; 
	
	private boolean visible;
	
	
	public LinearEquation(float k,float m, Graph graph, Color color){
		this.k = k;
		this.m = m;
		this.graph = graph;
		this.color = color;
		
		init();
	}
	
	public LinearEquation(float x_1, float y_1, float x_2, float y_2,  Graph graph, Color color){
		this.x_1 = x_1;
		this.y_1 = y_1;
		this.x_2 = x_2;
		this.y_2 = y_2;
		
		haveCordinats = true;
		
		this.k = calcK(x_1, y_1, y_2, x_2);
		this.m = calcM(x_1, y_1, this.k);
		this.graph = graph;
		this.color = color;
		init();
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		if(visible){
			g2d.setColor(color);
			for(float x = graph.getMinXaxis()*2;x <= graph.getMaxXaxis()*2;x+=0.0001){
				
				float y = k*x+m;
				
				if(y >= graph.getMinYaxis()&&y <= graph.getMaxYaxis()){
					g2d.drawLine((int)setXCoordinate(x), (int)setYCoordinate(y), (int)setXCoordinate(x), (int)setYCoordinate(y));
				}
			}
		}
	}

	public boolean setPoint1(Dot dot){
	
		if(dot.getPosX() == x_2){
			return false;
		}
		
		this.x_1 = dot.getPosX();
		this.y_1 = dot.getPosY();
		
		this.k = calcK(x_1, y_1, y_2, x_2);
		this.m = calcM(x_1, y_1, k);
		
		
		
		return haveCordinats;
	}
	public boolean setPoint2(Dot dot){
		
		if(dot.getPosX() == x_1){
			return false;
		}
		
		this.x_2 = dot.getPosX();
		this.y_2 = dot.getPosY();
		
		this.k = calcK(x_1, y_1, y_2, x_2);
		this.m = calcM(x_1, y_1, k);
		
		return haveCordinats;
	}
	@Override
	public void init() {
		visible = false;	
	}
	private float calcK(float x_1, float y_1, float y_2, float x_2){
		return (y_2-y_1)/(x_2-x_1);
	}
	private float calcM(float x, float y, float k){
		return (y-k*x);
	}
	public boolean testEquals(LinearEquation linearEquation){
		if(getM() == linearEquation.getM() && getK() == linearEquation.getK()){
			return true;
		}else{
			return false;
		}
		
	}
	private float getK() {
		return k;
	}
	private float getM() {
		return m;
	}
	public String getEquation(){
		if(m < 0){
			return "y = " +k+ "x - "+ Math.abs(m);
		}
		return "y = " +k+ "x + "+m;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
