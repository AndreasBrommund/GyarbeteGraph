
public class CoordinateHandler {
	
	protected static int scale = 20;
	
	protected static float setXCoordinate(float coordinate){
		coordinate *= scale;
		return coordinate+1+Game.screenWidth/2;
	}
	protected static float setYCoordinate(float coordinate){
		coordinate *= scale;
		return coordinate*-1+56+Game.screenHeight/2;
	}
}
