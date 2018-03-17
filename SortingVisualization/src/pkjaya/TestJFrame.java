package pkjaya;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TestJFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	MyLittlePanel contentaPane = new MyLittlePanel();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJFrame frame = new TestJFrame();
					frame.setLocationRelativeTo(null);										
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public TestJFrame() {
		JPanel contentPane = new JPanel();
		setTitle("Sorting Visualizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 471);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 32, 488, 400);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentaPane.setBounds(10, 39, 468, 382);
		contentPane.add(contentaPane);		
		JButton btnNewButton = new JButton("Merge");
		btnNewButton.setBounds(10, 5, 63, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(contentaPane);
				contentaPane.setCurrentOperation("Merge Sort");
				contentaPane.setOperationDescription("O(n log n)");
			    MergeSort.mergeSort(contentaPane.bits, 0,contentaPane.bits.length - 1);
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnHeap = new JButton("Heap");
		btnHeap.setBounds(72, 5, 63, 23);
		btnHeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(contentaPane);
				contentaPane.setCurrentOperation("Heap Sort");
				contentaPane.setOperationDescription("O(n log n)");
			    HeapSort.sort(contentaPane.bits);
			}
		});
		contentPane.add(btnHeap);
		
		JButton btnQuick = new JButton("Quick");
		btnQuick.setBounds(134, 5, 63, 23);
		btnQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(contentaPane);
				contentaPane.setCurrentOperation("Quick Sort");
				contentaPane.setOperationDescription("O(n log n)");
			    MergeSort.mergeSort(contentaPane.bits, 0,contentaPane.bits.length - 1);
			}
		});
		contentPane.add(btnQuick);
		
		JButton btnInsertion = new JButton("Insertion");
		btnInsertion.setBounds(321, 5, 63, 23);
		btnInsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(contentaPane);
				contentaPane.setCurrentOperation("Insertion Sort");
				contentaPane.setOperationDescription("O(n^2)");
			    SimpleSorts.insertionSort(contentaPane.bits);
			}
		});
		contentPane.add(btnInsertion);
		
		JButton btnBubble = new JButton("Bubble");
		btnBubble.setBounds(259, 5, 63, 23);
		btnBubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset(contentaPane);
				contentaPane.setCurrentOperation("Bubble Sort");
				contentaPane.setOperationDescription("O(n^2)");
			    SimpleSorts.bubbleSort(contentaPane.bits);
			}
		});
		contentPane.add(btnBubble);
		
		JButton btnShuffle = new JButton("Shuffle");
		btnShuffle.setBounds(394, 5, 84, 23);
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleSorts.shuffle(contentaPane.bits); }
			});
		contentPane.add(btnShuffle);
		
		JButton btnNewButton_1 = new JButton("Tim");
		btnNewButton_1.setBounds(197, 5, 63, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnNewButton_1);
		}
	private static void reset(MyLittlePanel panel) {
	    panel.resetStatistics();
	    SimpleSorts.shuffle(panel.bits);
	  }
}
