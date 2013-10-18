import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class EventHandler implements ActionListener, MouseListener{
	
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

	@Override
	public void mouseClicked(MouseEvent e) {
		game.getGameComponent().newPoint(e.getX(),e.getY());
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
