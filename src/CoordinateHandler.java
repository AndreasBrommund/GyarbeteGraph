import java.awt.Canvas;

public class CoordinateHandler extends Canvas{
	
	protected static int scale = 70;
	protected static float scaleXaxis = 1, scaleYaxis = 1;
	
	protected  float setXCoordinate(float coordinate){
		coordinate *= scale;
		coordinate *= scaleXaxis;
		return coordinate-24+Game.screenWidth/2;
	}
	protected float setYCoordinate(float coordinate){
		coordinate *= scale;
		coordinate *= scaleYaxis;
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
