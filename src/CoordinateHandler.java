import java.awt.Canvas;

public class CoordinateHandler extends Canvas{
	
	protected static int scale = 30;
	
	protected static float setXCoordinate(float coordinate){
		coordinate *= scale;
		return coordinate-24+600/2;
	}
	protected static float setYCoordinate(float coordinate){
		coordinate *= scale;
		return coordinate*-1+-70+720/2;
	}
}
