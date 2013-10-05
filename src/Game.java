import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	//Panels
	private Panel panelTop;
	private Panel panelRight;
	
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
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}
		SwingUtilities.updateComponentTreeUI(this);
		
		setScreen();
		
		add(gameComponent,BorderLayout.CENTER);
		add(panelTop,BorderLayout.NORTH);
		add(panelRight,BorderLayout.EAST);
		
		setVisible(true);
	}
	private void setScreen(){
		
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
		
		zoomIn.setText("+");
		zoomIn.setPreferredSize(zoomButtonDimension);
		zoomIn.setActionCommand("zoomInButton");
		
		zoomOut.setText("-");
		zoomOut.setPreferredSize(zoomButtonDimension);
		zoomOut.setActionCommand("zoomOutButton");
		
		testEquation.setText("Test");
		testEquation.setPreferredSize(testEquationDimension);
		testEquation.setAlignmentX(CENTER_ALIGNMENT);
		testEquation.setActionCommand("testEquation");
		
		equation.setText("2x+3");
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
	}
	
}