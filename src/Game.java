import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Game extends JFrame{
	//Basic stuff
	public static int screenWidth = 600;	 
	public static int screenHeight = 720;	
	public static String title = "Graph";
	
	//JButtons
	private JButton zoomIn;
	private JButton zoomOut;
	private JButton testEquation;
	
	//JLabels 
	private JLabel equation;
	
	//Canvas 
	private GameComponent gameComponent;
	
	//Dimensions
	private Dimension zoomButtonDimension;
	private Dimension testEquationDimension;
	private Dimension topPanelDimension;
	private Dimension rightPanelDimension;
	private Dimension scaleTextFieldDimension;
	
	//Panels
	private Panel panelTop;
	private Panel panelRight;
	
	//TextField
	private JTextField scaleX; 
	private JTextField scaleY;
	
	private EventHandler eventHandler;
	
	private final int rightPanelWidth = 50;
	
	public static void main(String[]args){
		new Game();
	}
	public Game(){
		super(title);
		
		setSize(screenWidth, screenHeight);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}
		SwingUtilities.updateComponentTreeUI(this);
		
		setScreen();
		
		add(panelTop,BorderLayout.NORTH);
		add(panelRight,BorderLayout.EAST);
		add(gameComponent,BorderLayout.CENTER);
		setVisible(true);
	}
	private void setScreen(){
		
		eventHandler = new EventHandler(this);
		
		scaleX = new JTextField();
		scaleY = new JTextField();
		
		panelRight = new Panel();
		panelTop = new Panel();
		
		zoomIn = new JButton();
		zoomOut = new JButton();
		testEquation = new JButton();
		
		equation = new JLabel();
		
		gameComponent = new GameComponent(this);
		
		zoomButtonDimension = new Dimension(rightPanelWidth-5, rightPanelWidth-5);
		testEquationDimension = new Dimension(100,50);
		topPanelDimension = new Dimension(getWidth(),100);
		rightPanelDimension = new Dimension(rightPanelWidth,getHeight());
		scaleTextFieldDimension = new Dimension(rightPanelWidth-5,rightPanelWidth-5);
		
		scaleX.setText("1");
		scaleX.setPreferredSize(scaleTextFieldDimension);
		scaleX.setActionCommand("scaleX");
		scaleX.addActionListener(eventHandler);
		
		scaleY.setText("1");
		scaleY.setPreferredSize(scaleTextFieldDimension);
		scaleY.setActionCommand("scaleY");
		scaleY.addActionListener(eventHandler);
		
		
		zoomIn.setText("+");
		zoomIn.setPreferredSize(zoomButtonDimension);
		zoomIn.setActionCommand("zoomInButton");
		zoomIn.addActionListener(eventHandler);
		
		zoomOut.setText("-");
		zoomOut.setPreferredSize(zoomButtonDimension);
		zoomOut.setActionCommand("zoomOutButton");
		zoomOut.addActionListener(eventHandler);
		
		testEquation.setText("Test");
		testEquation.setPreferredSize(testEquationDimension);
		testEquation.setAlignmentX(CENTER_ALIGNMENT);
		testEquation.setActionCommand("testEquation");
		
		equation.setText("2x+0");
		equation.setAlignmentX(CENTER_ALIGNMENT);
		
		panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));
		panelTop.setPreferredSize(topPanelDimension);
		panelTop.add(Box.createRigidArea(new Dimension(0,20)));
		panelTop.add(equation);
		panelTop.add(Box.createRigidArea(new Dimension(0,10)));
		panelTop.add(testEquation);
		
		panelRight.setPreferredSize(rightPanelDimension);
		panelRight.add(zoomIn);
		panelRight.add(zoomOut);
		panelRight.add(scaleX);
		panelRight.add(scaleY);
	}
	public GameComponent getGameComponent() {
		return gameComponent;
	}
	public JTextField getScaleX() {
		return scaleX;
	}
	public JTextField getScaleY() {
		return scaleY;
	}
}
