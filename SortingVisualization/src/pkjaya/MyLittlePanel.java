package pkjaya;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyLittlePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int UNITS = 100; // # of rectangles.
	public  int[] bits = new int[UNITS]; // 
	private String currentOperation = ""; // Current Sort (bubble, heap, ... )
	private String operationDescription = ""; // cureent Operation (Lg n / n^2 ... )
	
	public void resetStatistics() {
	    currentOperation = "";
	    operationDescription = "";
	  }

	  public void setCurrentOperation(String currentOperation) {
	    this.currentOperation = currentOperation;
	  }

	  public void setOperationDescription(String OperationDescription) {
	    this.operationDescription = OperationDescription;
	  }
	  
	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
		for (int i = 0; i < bits.length; i++)
			bits[i] = i; // I wanna take color to each element (Rectangle)
	 // Draw Rectangles
	    for (int i = 0; i < UNITS; i++) {	
	      g.setColor(Color.getHSBColor((bits[i] / (float) UNITS), 1, 1));
	      int x = (int) Math.floor(i * (getWidth() / (float) UNITS));
	      int y = (int) Math.floor(getHeight() - (bits[i] / (float) UNITS) * getHeight()) - 1;
	      int width = (int) Math.ceil(getWidth() / (float) UNITS);
	      int height = getHeight() - y;
	      g.fillRect(x, y, width, height);
	    }

	    // Text drawing
	    int textHeight = g.getFontMetrics().getHeight();
	    g.setColor(Color.BLUE);
	    g.drawString(currentOperation, 0, textHeight);
	    g.setColor(Color.BLACK);
	    g.drawString(operationDescription, 0, textHeight * 2);
	  }

}
