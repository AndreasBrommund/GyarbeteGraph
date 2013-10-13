import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class EventHandler implements ActionListener{
	
	private Game game;
	
	public EventHandler(Game game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "zoomOutButton":
			CoordinateHandler.zoomOut();
			break;
		case "zoomInButton":
			CoordinateHandler.zoomIn();
			break;
		}
		game.getGameComponent().uppdateScreen();
	}
}
