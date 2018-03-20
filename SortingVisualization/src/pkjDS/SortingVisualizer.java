package pkjDS;

import javax.swing.*;

import static pkjDS.MyLilPane.setUnits;

import java.util.Arrays;
import java.util.Scanner;


public class SortingVisualizer  {

	private static Scanner s;

	public static void main(String[] args) throws InterruptedException {
		s = new Scanner(System.in);
		System.out.println("Please, enter the length of the array?");
		setUnits(s.nextInt());
		JFrame demo = new JFrame("Sorting Visualizer");
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyLilPane pane = new MyLilPane();
		demo.add(pane);
		demo.pack();
		demo.setLocationRelativeTo(null);
		demo.setVisible(true);
		Thread.sleep(3000);
		new Thread(new Runnable() {
			@Override
			public void run() {
				// only repaint if bits[] changes
				int[] clona = new int[pane.bits.length];

				while (true) {
					if (!Arrays.equals(clona, pane.bits)) {
						pane.repaint();
						clona = pane.bits.clone();
					}

					try {
						Thread.sleep(5);

					} catch (InterruptedException e) {
						System.out.println("Exception!");
					}
				}
			}
		}).start();

		while (true) {
			
			reset(pane);
			pane.setCurrentOperation("Quick Sort");
			pane.setOperationDescription("Θ(n log(n))");
			QuickSort.sort(pane.bits, 0, pane.bits.length - 1);
			Thread.sleep(1000);
			
			reset(pane);
			pane.setCurrentOperation("Merge Sort");
			pane.setOperationDescription("Θ(n log(n))");
			MergeSort.mergeSort(pane.bits, 0, pane.bits.length - 1);
			Thread.sleep(1000);
			
			reset(pane);
			pane.setCurrentOperation("Heap Sort");
			pane.setOperationDescription("Θ(n log(n))");
			HeapSort.sort(pane.bits);
			Thread.sleep(1000);
			
			reset(pane);
			pane.setCurrentOperation("Bubble Sort");
			pane.setOperationDescription("Θ(n^2)");
			SimpleSorts.bubbleSort(pane.bits);
			Thread.sleep(1000);
			
			reset(pane);
			pane.setCurrentOperation("Insertion Sort");
			pane.setOperationDescription("Θ(n^2)");
			SimpleSorts.insertionSort(pane.bits);
			Thread.sleep(1000);

			reset(pane);
			pane.setCurrentOperation("Selection Sort");
			pane.setOperationDescription("Θ(n^2)");
			SimpleSorts.selectionSort(pane.bits);
			Thread.sleep(1000);
			
			reset(pane);
			pane.setCurrentOperation("Radix Sort");
			pane.setOperationDescription("Θ(nk)");
			RadixSort.sort(pane.bits);
			Thread.sleep(1000);

			reset(pane);
			pane.setCurrentOperation("Counting Sort");
			pane.setOperationDescription("Θ(n+k)");
			CountingSort.sort(pane.bits);
			Thread.sleep(1000);

		}
	}

	private static void reset(MyLilPane panel) {
		panel.resetStatistics();
		SimpleSorts.shuffle(panel.bits);
	}
}
