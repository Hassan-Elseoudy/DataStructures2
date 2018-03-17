package pkjaya;

import java.awt.Dimension;
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
	MyLittlePanel contentPane = new MyLittlePanel();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJFrame frame = new TestJFrame();
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
		setTitle("Sorting Visualizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 471);
		contentPane.setPreferredSize(new Dimension(512, 512));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 32, 488, 400);
		contentPane.add(panel);
		JButton btnNewButton = new JButton("Merge");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setCurrentOperation("Merge Sort");
				contentPane.setOperationDescription("O(n log n)");
			    MergeSort.mergeSort(contentPane.bits, 0,contentPane.bits.length - 1);
			}
		});
		btnNewButton.setBounds(10, 5, 63, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHeap = new JButton("Heap");
		btnHeap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setCurrentOperation("Heap Sort");
				contentPane.setOperationDescription("O(n log n)");
			    HeapSort.sort(contentPane.bits);
			}
		});
		btnHeap.setBounds(72, 5, 63, 23);
		contentPane.add(btnHeap);
		
		JButton btnQuick = new JButton("Quick");
		btnQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setCurrentOperation("Merge Sort");
				contentPane.setOperationDescription("O(n log n)");
			    MergeSort.mergeSort(contentPane.bits, 0,contentPane.bits.length - 1);
			}
		});
		btnQuick.setBounds(134, 5, 63, 23);
		contentPane.add(btnQuick);
		
		JButton btnInsertion = new JButton("Insertion");
		btnInsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setCurrentOperation("Insertion Sort");
				contentPane.setOperationDescription("O(n^2)");
			      SimpleSorts.insertionSort(contentPane.bits);
			}
		});
		btnInsertion.setBounds(321, 5, 63, 23);
		contentPane.add(btnInsertion);
		
		JButton btnBubble = new JButton("Bubble");
		btnBubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setCurrentOperation("Bubble Sort");
				contentPane.setOperationDescription("O(n^2)");
			    SimpleSorts.bubbleSort(contentPane.bits);
			}
		});
		btnBubble.setBounds(259, 5, 63, 23);
		contentPane.add(btnBubble);
		
		JButton btnShuffle = new JButton("Shuffle");
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SimpleSorts.shuffle(contentPane.bits); }
			});
		
		
		btnShuffle.setBounds(394, 5, 84, 23);
		contentPane.add(btnShuffle);
		
		JButton btnNewButton_1 = new JButton("Tim");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(197, 5, 63, 23);
		contentPane.add(btnNewButton_1);
	}
}
