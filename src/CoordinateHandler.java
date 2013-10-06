import java.awt.Canvas;

public class CoordinateHandler extends Canvas{
	
	protected static int scale = 70;
	
	protected  float setXCoordinate(float coordinate){
		coordinate *= scale;
		return coordinate-24+Game.screenWidth/2;
	}
	protected float setYCoordinate(float coordinate){
		coordinate *= scale;
		return coordinate*-1-70+Game.screenHeight/2;
	}
	
	public static void zoomIn(){
		scale += 5;
	}
	public static void zoomOut(){
		if(scale > 5){
			scale -= 5;
			
		}
	}
}
