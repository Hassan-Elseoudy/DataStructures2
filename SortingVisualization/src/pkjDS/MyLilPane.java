package pkjDS;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyLilPane extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int UNITS = 200;

	public int[] bits = new int[UNITS];
	private int[] active = new int[UNITS];
	private String currentOperation = "";
	private String operationDescription = "";

	public MyLilPane() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(512, 512));

		for (int i = 0; i < bits.length; i++) {
			bits[i] = i;
		}
	}

	public static void setUnits(int x) {
		UNITS = x;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("X:\\Smsm\\DS_Lab1\\src\\pkjaya\\maxresdefault.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, -1400, -200, null);

		for (int i = 0; i < UNITS; i++) {
			g.setColor(Color.getHSBColor((bits[i] / (float) UNITS), 1, 1));
			int x = (int) Math.floor(i * (getWidth() / (float) UNITS));
			int y = (int) Math.floor(getHeight() - (bits[i] / (float) UNITS) * getHeight()) - 1;
			int width = (int) Math.ceil(getWidth() / (float) UNITS);
			int height = getHeight() - y;
			g.fillRect(x, y, width, height);
			if (i == active[0] || i == active[1]) {
				g.setColor(Color.WHITE);
				g.drawRect(x, y, width, height);
			}
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
