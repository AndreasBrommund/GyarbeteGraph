import java.awt.Canvas;

public class CoordinateHandler extends Canvas{
	
	protected static int scale = 70;
	final protected static float scaleXaxis = 1, scaleYaxis = 1;
	
	protected  float setXCoordinate(float coordinate){
		coordinate *= scale;
		
		return coordinate+543/2;
	}
	protected float setYCoordinate(float coordinate){
		coordinate *= scale;
		
		return coordinate*-1+590/2;
	}
	protected float getXCoordinate(float coordinate){
		
		return (coordinate-543/2)/scale;
	}
	protected float getYCoordinate(float coordinate){
		
		return ((coordinate-590/2)/scale)*-1;
	}
	
	public static void zoomIn(){
		scale += 4;
	}
	public static void zoomOut(){
		if(scale > 28){
			scale -= 4;
			
		}
	}
}
