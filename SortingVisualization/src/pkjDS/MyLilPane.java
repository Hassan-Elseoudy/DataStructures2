package pkjDS;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyLilPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int rectangles = 0;
	public static int delay = 0;
	public int[] arr = new int[rectangles];
	private String currentOperation = "";
	private String operationDescription = "";

	public MyLilPane() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(512, 512));

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
	}

	public static void setUnits(int x) {
		rectangles = x;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < rectangles; i++) {
			g.setColor(Color.getHSBColor((arr[i] / (float) rectangles), 1, 1));
			int x = (int) Math.floor(i * (getWidth() / (float) rectangles));
			int y = (int) Math.floor(getHeight() - (arr[i] / (float) rectangles) * getHeight()) - 1;
			int width = (int) Math.ceil(getWidth() / (float) rectangles);
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
}
